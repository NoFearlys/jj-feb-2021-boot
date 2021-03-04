package com.lesson3.jjfeb2021.models.DAO;

import com.lesson3.jjfeb2021.models.Client;
import com.lesson3.jjfeb2021.models.Status;
import com.lesson3.jjfeb2021.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class TaskDao {
    private final EntityManager manager;

    @Autowired
    public TaskDao( EntityManager manager) {
        this.manager = manager;
    }

    public List<Task> findAllTasks() {
        try{
        return manager
                .createQuery("from Task", Task.class)
                .getResultList();
        }
        catch (NoResultException notFound){
            return null;
        }
    }

    public List<Task> findByStatus(Status status) {
        try{
        return manager
                .createQuery("from Task where status = :status", Task.class)
                .setParameter("status", status)
                .getResultList();
        }
        catch (NoResultException notFound){
            return null;
        }
    }

    public List<Task> findByClientPhone(String clientPhone) {
        try{
            return manager
                    .createQuery("from Task t where t.client.phone= :clientPhone", Task.class)
                    .setParameter("clientPhone", clientPhone)
                    .getResultList();
        }
        catch (NoResultException notFound){
            return null;
        }
    }

    public List<Task> findByTrackNumber(String trackNumber) {
        try{
            return manager
                    .createQuery("from Task where trackNumberIn= :trackNumber or trackNumberOut= :trackNumber", Task.class)
                    .setParameter("trackNumber", trackNumber)
                    .getResultList();
        }
        catch (NoResultException notFound){
            return null;
        }
    }

    public void add(Task task){
        manager.getTransaction().begin();
        manager.persist(task);
        manager.getTransaction().commit();
    }

    public void remove(Task task){
        manager.getTransaction().begin();
        manager.remove(task);
        manager.getTransaction().commit();
    }

}
