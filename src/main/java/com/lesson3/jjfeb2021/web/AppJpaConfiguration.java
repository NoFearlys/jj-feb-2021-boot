package com.lesson3.jjfeb2021.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

    @Configuration
    @EnableJpaRepositories(basePackages = "com.lesson3.jjfeb2021.models")
    @EnableTransactionManagement
    public class AppJpaConfiguration {
        @Bean
        public EntityManagerFactory entityManagerFactory() {
            return Persistence.createEntityManagerFactory("MainPersistenceUnit");
        }
    }
