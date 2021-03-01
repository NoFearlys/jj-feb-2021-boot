package com.lesson3.jjfeb2021.models.DAO;

import com.lesson3.jjfeb2021.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ModelDao {
    private final EntityManager manager;

    @Autowired
    public ModelDao(EntityManager manager) {
        this.manager = manager;
    }

    public List<Model> findAllModels() {
        return manager.createQuery("from Model", Model.class).getResultList();
    }

    public List<Model> findByVersion(String version) {
        return manager
                .createQuery("from Model where Model.version= :version", Model.class)
                .setParameter("version", version)
                .getResultList();
    }

    public void add(Model model){
        manager.persist(model);
    }

    public void remove(Model model){
        manager.remove(model);
    }
}
