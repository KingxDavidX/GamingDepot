package com.example.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    //This was what was broken
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String path = request.getRequestURI();
        String header = request.getHeader("Authorization");

        try {
            if (StringUtils.hasText(header) && header.startsWith("Bearer ")) {
                String token = header.substring(7);
                log.debug("JwtFilter: found Authorization header, validating token for path={}", path);
                Jws<Claims> claimsJws = jwtUtil.validateToken(token);
                Claims claims = claimsJws.getBody();
                String username = claims.getSubject();

                if (username != null) {
                    UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(auth);
                    log.debug("JwtFilter: Authentication set for user '{}'", username);
                }
            } else {
                log.debug("JwtFilter: no Authorization header for path={}", path);
            }
        } catch (JwtException ex) {
            // Invalid token — clear context and log reason, but don't write response here
            log.warn("JwtFilter: invalid token for path={}, reason={}", path, ex.getMessage());
            SecurityContextHolder.clearContext();
        } catch (Exception ex) {
            // Unexpected error — log and clear context
            log.error("JwtFilter: unexpected error validating token for path=" + path, ex);
            SecurityContextHolder.clearContext();
        }

        filterChain.doFilter(request, response);
    }
}
