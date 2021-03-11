package com.lesson3.jjfeb2021.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

    @Configuration
    @EnableJpaRepositories(basePackages = "com.lesson3.jjfeb2021.models")
    public class AppJpaConfiguration {
        @Bean
        public EntityManager entityManager(EntityManagerFactory factory) {
            return factory.createEntityManager();
        }
        @Bean
        public EntityManagerFactory entityManagerFactory() {
            return Persistence.createEntityManagerFactory("MainPersistenceUnit");
        }
    }
