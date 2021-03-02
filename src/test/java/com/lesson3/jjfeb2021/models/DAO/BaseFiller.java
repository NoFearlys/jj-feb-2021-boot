package com.lesson3.jjfeb2021.models.DAO;

import com.lesson3.jjfeb2021.models.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoTestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseFiller {

    @Autowired
    private static ModelDao modelDao;
    @Autowired
    private static CityDao cityDao;
    @Autowired
    private static ClientDao clientDao;
    @Autowired
    private static TaskDao taskDao;

    public void fill(EntityManager manager) {
        manager.getTransaction().begin();

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

        Task task = new Task(client, 3, 1354646345, 1356666662, Status.SENT);
        Task task1 = new Task(client1, 1, 1352323423, 1353543432, Status.WAITING);
        Task task2 = new Task(client3, 5, 1323423345, 1345435332, Status.WAITING);
        Task task3 = new Task(client5, 1, 1323426345, 1354335432, Status.OPERATION);
        Task task4 = new Task(client2, 1, 1323444245, 1335435432, Status.RECEIVED);
        Task task5 = new Task(client4, 3, 1357565345, 1343354352, Status.PAID);
        Task task6 = new Task(client1, 2, 1375566745, 1435433352, Status.SENT);
        Task task7 = new Task(client4, 7, 1675675665, 1353433542, Status.WAITING);
        Task task8 = new Task(client2, 1, 1357675677, 1354543332, Status.RECEIVED);
        Task task9 = new Task(client, 6, 1354567557, 1354354332, Status.SENT);


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

        manager.persist(client);
        manager.persist(client1);
        manager.persist(client2);
        manager.persist(client3);
        manager.persist(client4);
        manager.persist(client5);
/*
        manager.persist(task);
        manager.persist(task1);
        manager.persist(task2);
        manager.persist(task3);
        manager.persist(task4);
        manager.persist(task5);
        manager.persist(task6);
        manager.persist(task7);
        manager.persist(task8);
        manager.persist(task9);
*/
        manager.getTransaction().commit();

        System.out.println("done");
    }
}
