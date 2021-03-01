package com.lesson3.jjfeb2021.models.DAO;

import com.lesson3.jjfeb2021.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class CityDao {
    private final EntityManager manager;

    @Autowired
    public CityDao(EntityManager manager) {
        this.manager = manager;
    }

    public List<City> findAll() {return manager.createQuery("from City", City.class).getResultList();}

    public void add(City city){
        manager.getTransaction().begin();
        manager.persist(city);
        manager.getTransaction().commit();
    }

    public void remove(City city){
        manager.getTransaction().begin();
        manager.remove(city);
        manager.getTransaction().commit();
    }
}
