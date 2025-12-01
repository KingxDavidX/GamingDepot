package com.example.config;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
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
        entityManagerFactoryRef = "userEntityManager",
        basePackages = {"com.example.repositories.user"},
        transactionManagerRef = "userTransactionManager"
)
public class UserDBConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.transactions")
    public DataSourceProperties userDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource userDataSource(@Qualifier("userDataSourceProperties") DataSourceProperties dsp) {
        return dsp.initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean userEntityManager(EntityManagerFactoryBuilder builder,
                                                                    @Qualifier("userDataSource") DataSource ds) {
        return builder
                .dataSource(ds)
                .packages("com.example.transactions.models")
                .persistenceUnit("userPU")
                .build();
    }

    @Bean
    public PlatformTransactionManager userTransactionManager(
            @Qualifier("userEntityManager") LocalContainerEntityManagerFactoryBean emf) {
        return new JpaTransactionManager(Objects.requireNonNull(emf.getObject()));
    }
}
