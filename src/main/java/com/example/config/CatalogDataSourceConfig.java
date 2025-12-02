package com.example.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class CatalogDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.catalog")
    public DataSourceProperties catalogDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "catalogDataSource")
    public DataSource catalogDataSource(@Qualifier("catalogDataSourceProperties") DataSourceProperties dsp) {
        return dsp.initializeDataSourceBuilder().build();
    }

    @Bean(name = "catalogNamedjdbc")
    public NamedParameterJdbcTemplate catalogjdbc(@Qualifier("catalogDataSource") DataSource ds) {
        return new NamedParameterJdbcTemplate(ds);
    }


}
