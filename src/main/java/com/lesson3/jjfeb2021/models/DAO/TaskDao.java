package com.lesson3.jjfeb2021.models.DAO;

import com.lesson3.jjfeb2021.models.Client;
import com.lesson3.jjfeb2021.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TaskDao {
    private final EntityManager manager;

    @Autowired
    public TaskDao( EntityManager manager) {
        this.manager = manager;
    }

    public List<Task> findAllTasks() {
        return manager.createQuery("from Task", Task.class).getResultList();
    }

    public List<Task> findByStatus(int status) {
        return manager
                .createQuery("from Task where Task.status= :status", Task.class)
                .setParameter("status", status)
                .getResultList();
    }

    public List<Task> findByClient(Client client) {
        return manager
                .createQuery("from Task where Task.client= :client", Task.class)
                .setParameter("client", client)
                .getResultList();
    }

    public void add(Task task){manager.persist(task);}

    public void remove(Task task){manager.remove(task);}

}
