package com.example.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class TransactionsDataSourceConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.transactions")
    public DataSourceProperties transactionsDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "transactionsDataSource")
    public DataSource transactionsDataSource(@Qualifier("transactionsDataSourceProperties") DataSourceProperties dsp) {
        return dsp.initializeDataSourceBuilder().build();
    }

    @Bean(name = "transactionsNamedjdbc")
    public NamedParameterJdbcTemplate transactionsjdbc(@Qualifier("transactionsDataSource") DataSource ds) {
        return new NamedParameterJdbcTemplate(ds);
    }


}
