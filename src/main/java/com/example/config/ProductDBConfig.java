package com.example.config;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.*;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "productEntityManager",
        basePackages = {"com.example.repositories.catalog"},
        transactionManagerRef = "productTransactionManager"
)
public class ProductDBConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.catalog")
    public DataSourceProperties productDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource productDataSource(@Qualifier("productDataSourceProperties") DataSourceProperties dsp) {
        return dsp.initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean productEntityManager(EntityManagerFactoryBuilder builder,
                                                                       @Qualifier("productDataSource") DataSource ds) {
        return builder
                .dataSource(ds)
                .packages("com.example.models")
                .persistenceUnit("productPU")
                .build();
    }


    @Bean
    public PlatformTransactionManager productTransactionManager(
            @Qualifier("productEntityManager")LocalContainerEntityManagerFactoryBean emf){
        return new JpaTransactionManager(Objects.requireNonNull(emf.getObject()));
    }
}
