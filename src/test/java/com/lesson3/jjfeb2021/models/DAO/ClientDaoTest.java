package com.lesson3.jjfeb2021.models.DAO;

import com.lesson3.jjfeb2021.models.Model;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoTestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ClientDaoTest {

    @Autowired
    private EntityManager manager;
    @Autowired
    private ClientDao clientDao;

    @Before
    public void configure(){
        BaseFiller baseFiller = new BaseFiller();
        baseFiller.fill(manager);

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