package com.exercise.sandbox.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Data source configuration.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.exercise.sandbox.repository")
public class RepositoryConfiguration {
}
