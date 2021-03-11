package com.lesson3.jjfeb2021.models.DAO;

import com.lesson3.jjfeb2021.models.Client;
import com.lesson3.jjfeb2021.models.Model;
import com.lesson3.jjfeb2021.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class ClientDao {
    private final EntityManager manager;

    @Autowired
    public ClientDao(EntityManager manager) {
        this.manager = manager;
    }

    public List<Client> findAllClients() {
        try{
        return manager
                .createQuery("from Client", Client.class)
                .getResultList();
        }
        catch (NoResultException notFound){
            return null;
        }
    }

    public List<Client> findByName(String name) {
        try{
            return manager
                    .createQuery("from Client where name= :name", Client.class)
                    .setParameter("name", name)
                    .getResultList();
        }
        catch (NoResultException notFound){
            return null;
        }
    }

    public List<Client> findByCityName(String cityName) {
        try{
            return manager
                    .createQuery("from Client c where c.city.name= :cityName", Client.class)
                    .setParameter("cityName", cityName)
                    .getResultList();
        }
        catch (NoResultException notFound){
            return null;
        }
    }

    public List<Client> findByModelName(String modelName) {
        try{
        return manager
                .createQuery("from Client c where c.model.name= :modelName", Client.class)
                .setParameter("modelName", modelName)
                .getResultList();
        }
        catch (NoResultException notFound){
            return null;
        }
    }

    public Client findById(int id){
       return manager.find(Client.class, id);
    }

    public void add(Client client){
        manager.getTransaction().begin();
        manager.persist(client);
        manager.getTransaction().commit();
    }

    public void remove(Client client){
        manager.remove(client);
    }
}
