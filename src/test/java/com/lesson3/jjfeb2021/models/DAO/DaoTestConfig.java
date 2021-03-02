package com.lesson3.jjfeb2021.models.DAO;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@ComponentScan(basePackages = "com.lesson3.jjfeb2021.models")
public class DaoTestConfig {

    @Bean
    public EntityManager entityManager(EntityManagerFactory factory){
        return factory.createEntityManager();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(){
        return Persistence.createEntityManagerFactory("TestPersistenceUnit");
    }

}
