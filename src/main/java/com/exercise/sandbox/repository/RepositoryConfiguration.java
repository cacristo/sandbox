package com.exercise.sandbox.repository;

import com.exercise.sandbox.entity.EntityConstant;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

/**
 * Data source configuration.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.exercise.sandbox.repository", entityManagerFactoryRef = "entityManagerFactory")
public class RepositoryConfiguration {

    @Bean("dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("entityManagerFactory")
    @ConfigurationProperties(prefix = "spring.jpa")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("dataSource") DataSource datasource) {
        return builder.dataSource(datasource).packages(EntityConstant.class).persistenceUnit("sandboxEM").build();
    }
}
