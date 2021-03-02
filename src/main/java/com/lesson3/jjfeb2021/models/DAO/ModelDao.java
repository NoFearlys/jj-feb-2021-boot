package com.lesson3.jjfeb2021.models.DAO;

import com.lesson3.jjfeb2021.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class ModelDao {
    private final EntityManager manager;

    @Autowired
    public ModelDao(EntityManager manager) {
        this.manager = manager;
    }

    public List<Model> findAllModels() {
        try {
            return manager
                    .createQuery("from Model", Model.class)
                    .getResultList();
        }
        catch (NoResultException notFound){
            return null;
        }
    }

    public List<Model> findByVersion(String version) {
        try {
            return manager
                    .createQuery("from Model where version = :version", Model.class)
                    .setParameter("version", version)
                    .getResultList();
        }
        catch (NoResultException notFound){
            return null;
        }
    }

    public List<Model> findByName(String name) {
        try {
            return manager
                    .createQuery("from Model where name = :name", Model.class)
                    .setParameter("name", name)
                    .getResultList();
        }
        catch (NoResultException notFound){
            return null;
        }
    }

    public void add(Model model){
        manager.getTransaction().begin();
        manager.persist(model);
        manager.getTransaction().commit();
    }

    public void remove(Model model){
        manager.getTransaction().begin();
        manager.remove(model);
        manager.getTransaction().commit();
    }
}
