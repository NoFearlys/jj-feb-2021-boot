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
public class TaskDaoTest {

    @Autowired
    private EntityManager manager;
    @Autowired
    private ModelDao modelDao;
    @Autowired
    private TaskDao taskDao;

    private Task task;

    @Before
    public void configure(){
        BaseFiller baseFiller = new BaseFiller();
        baseFiller.fill(manager);

        Model model = new Model("Хонкон", "2.0.H", 3500, "00F1", "270F");
        City city = new City("Спб");
        Client client = new Client("Семён", city, "Второй адрес", "4654865", model);


        task = new Task(client, 3, "1354646345", "9999999999", Status.SENT);
    }

    @Test
    public void findAllTasks() {
        assertEquals(10, taskDao.findAll().size());
    }

    @Test
    public void findByStatus() {
        List<Task> results= taskDao.findByStatus(Status.WAITING);

        for(Task t : results){
            assertEquals("Ожидается", t.getStatus().getTitle());
        }
        assertEquals(3, results.size());
    }

    @Test
    public void findByClientPhone() {
        List<Task> results= taskDao.findByClientPhone("9443824");

        for(Task t : results){
            assertEquals("9443824", t.getClient().getPhone());
        }
        assertEquals(2, results.size());
    }

    @Test
    public void findByTrackNumber() {
        List<Task> results= taskDao.findByTrackNumber("1353433542");

        for(Task t : results) {
            assertTrue(t.getTrackNumber() == "1353433542");
        }
        assertEquals(2, results.size());
    }
}