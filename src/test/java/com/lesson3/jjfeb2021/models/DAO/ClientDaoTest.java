package com.lesson3.jjfeb2021.models.DAO;

import com.lesson3.jjfeb2021.models.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoTestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ClientDaoTest {

    @Autowired
    private EntityManager manager;
    @Autowired
    private ClientDao clientDao;

    private Client client;

    @Before
    public void configure(){
        BaseFiller baseFiller = new BaseFiller();
        baseFiller.fill(manager);

        Model model = new Model("Хонкон", "2.0.H", 3500, "00F1", "270F");
        City city = new City("Спб");
        client = new Client("Семён", city, "Второй адрес", "4654865", model);
    }

    @Test
    public void findAllClients() {
        assertEquals(6, clientDao.findAllClients().size());
    }

    @Test
    public void findByName() {
        List<Client> results= clientDao.findByName("Полина");

        for(Client c : results){
            assertEquals("Полина", c.getName());
        }
        assertEquals(2, results.size());
    }

    @Test
    public void findByCityName() {
        List<Client> results= clientDao.findByCityName("Спб");

        for(Client c : results){
            assertEquals("Спб", c.getCity().getName());
        }
        assertEquals(1, results.size());
    }

    @Test
    public void findByModelName() {
        List<Client> results= clientDao.findByModelName("Стандартный");

        for(Client c : results){
            assertEquals("Стандартный", c.getModel().getName());
        }
        assertEquals(3, results.size());
    }

    @Test
    public void add() {
        clientDao.add(client);
        assertEquals("Семён", clientDao.findByName("Семён").get(0).getName());
    }

    @Test
    public void remove() {
        clientDao.add(client);
        int clientId = clientDao.findByName("Семён").get(0).getClientId();
        clientDao.remove(client);
        assertNull(manager.find(Client.class, clientId));
    }
}