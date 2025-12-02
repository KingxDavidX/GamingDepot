package com.example.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSourceConfig {

    // Catalog (Products)
    @Bean
    @ConfigurationProperties("spring.datasource.catalog")
    public DataSourceProperties catalogDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "catalogDataSource")
    public DataSource catalogDataSource(@Qualifier("catalogDataSourceProperties") DataSourceProperties p) {
        return p.initializeDataSourceBuilder().build();
    }

    @Bean(name = "catalogJdbcTemplate")
    public JdbcTemplate catalogJdbcTemplate(@Qualifier("catalogDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    // Transactions (Users / Orders)
    @Bean
    @ConfigurationProperties("spring.datasource.transactions")
    public DataSourceProperties transactionsDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "transactionsDataSource")
    public DataSource transactionsDataSource(@Qualifier("transactionsDataSourceProperties") DataSourceProperties p) {
        return p.initializeDataSourceBuilder().build();
    }

    @Bean(name = "transactionsJdbcTemplate")
    public JdbcTemplate transactionsJdbcTemplate(@Qualifier("transactionsDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }
}
