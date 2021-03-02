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

    public List<Client> findByCity(City city) {
        try{
        return manager
                .createQuery("from Client where Client.city= :city", Client.class)
                .setParameter("city", city)
                .getResultList();
        }
        catch (NoResultException notFound){
            return null;
        }
    }

    public List<Client> findByModel(Model model) {
        try{
        return manager
                .createQuery("from Client where Client.model= :model", Client.class)
                .setParameter("model", model)
                .getResultList();
        }
        catch (NoResultException notFound){
            return null;
        }
    }

    public void add(Client client){manager.persist(client);}

    public void remove(Client client){manager.remove(client);}
}
