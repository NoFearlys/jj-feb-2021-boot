package com.lesson3.jjfeb2021.models.DAO;

import com.lesson3.jjfeb2021.models.Client;
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

    public List<Task> findByStatus(int status) {
        try{
        return manager
                .createQuery("from Task where Task.status= :status", Task.class)
                .setParameter("status", status)
                .getResultList();
        }
        catch (NoResultException notFound){
            return null;
        }
    }

    public List<Task> findByClient(Client client) {
        try{
        return manager
                .createQuery("from Task where Task.client= :client", Task.class)
                .setParameter("client", client)
                .getResultList();
        }
        catch (NoResultException notFound){
            return null;
        }
    }

    public void add(Task task){manager.persist(task);}

    public void remove(Task task){manager.remove(task);}

}
