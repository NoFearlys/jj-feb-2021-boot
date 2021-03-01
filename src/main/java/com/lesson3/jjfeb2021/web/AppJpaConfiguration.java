package com.lesson3.jjfeb2021.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppJpaConfiguration {
    @Configuration
    public class AppJPAConfiguration {
        @Bean
        public EntityManager entityManager(EntityManagerFactory factory) {
            return factory.createEntityManager();
        }

        @Bean
        public EntityManagerFactory entityManagerFactory() {
            return Persistence.createEntityManagerFactory("AppPersistenceUnit");
        }
    }
}
