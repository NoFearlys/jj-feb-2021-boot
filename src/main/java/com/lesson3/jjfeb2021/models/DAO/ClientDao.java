package com.lesson3.jjfeb2021.models.DAO;

import com.lesson3.jjfeb2021.models.Client;
import com.lesson3.jjfeb2021.models.Model;
import com.lesson3.jjfeb2021.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClientDao {
    private final EntityManager manager;

    public ClientDao(@Autowired EntityManager manager) {
        this.manager = manager;
    }

    public List<Client> findAllClients() {
        return manager.createQuery("from Client", Client.class).getResultList();
    }

    public List<Client> findByCity(City city) {
        return manager
                .createQuery("from Client where Client.city= :city", Client.class)
                .setParameter("city", city)
                .getResultList();
    }

    public List<Client> findByModel(Model model) {
        return manager
                .createQuery("from Client where Client.model= :model", Client.class)
                .setParameter("model", model)
                .getResultList();
    }

    public void add(Client client){manager.persist(client);}

    public void remove(Client client){manager.remove(client);}
}
