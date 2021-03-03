package com.lesson3.jjfeb2021.models.DAO;

import com.lesson3.jjfeb2021.models.City;
import com.lesson3.jjfeb2021.models.Client;
import com.lesson3.jjfeb2021.models.Model;
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
    @Autowired
    private ModelDao modelDao;
    @Autowired
    private CityDao cityDao;

    @Before
    public void configure(){
        //BaseFiller baseFiller = new BaseFiller();
        //baseFiller.fill(manager);

        Model model = new Model("Стандартный", "2.0.H", 3500, "00F1", "270F");
        Model model1 = new Model("Стандартный", "2.0.H", 3500, "00F1", "270F");
        Model model2 = new Model("Черный", "2.3.H", 3500, "00F1", "270F");
        Model model3 = new Model("Белый", "2.1.H", 3500, "00F1", "270F");
        Model model4 = new Model("Дабло", "4.0.H", 10000, "00F1", "270F");
        Model model5 = new Model("Хонкон", "2.0.H", 3500, "00F1", "270F");

        City city = new City("Спб");
        City city1 = new City("МСК");
        City city2 = new City("Омск");
        City city3 = new City("Киев");

        Client client = new Client("Александр", city1, "Первый адрес", 9443824, model2);
        Client client1 = new Client("Маргарита", city2, "Второй адрес", 4654865, model3);
        Client client2 = new Client("Полина", city3, "Третий адрес", 3153846, model4);
        Client client3 = new Client("Сергей", city2, "Четвёртый адрес", 6466423, model2);
        Client client4 = new Client("Полина", city2, "Пятый адрес", 6543132, model1);
        Client client5 = new Client("Василий", city1, "Шестой адрес", 1568513, model5);

        manager.getTransaction().begin();

        manager.persist(model);
        manager.persist(model1);
        manager.persist(model2);
        manager.persist(model3);
        manager.persist(model4);
        manager.persist(model5);

        manager.persist(city);
        manager.persist(city1);
        manager.persist(city2);
        manager.persist(city3);

        manager.getTransaction().commit();
        manager.getTransaction().begin();

        manager.persist(client);
        manager.persist(client1);
        manager.persist(client2);
        manager.persist(client3);
        manager.persist(client4);
        manager.persist(client5);

        manager.getTransaction().commit();

        List<Model> models = modelDao.findAllModels();
        for (Model m : models) {
            System.out.println(m.getName());
        }

        List<City> cities = cityDao.findAll();
        for (City c : cities) {
            System.out.println(c.getName());
        }


    }

    @Test
    public void findAllClients() {
    }

    @Test
    public void findByCity() {
    }

    @Test
    public void findByModel() {
    }

    @Test
    public void add() {
    }

    @Test
    public void remove() {
    }
}