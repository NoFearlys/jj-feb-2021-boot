package com.lesson3.jjfeb2021.models.DAO;

import com.lesson3.jjfeb2021.models.City;
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
public class CityDaoTest {

    @Autowired
    private EntityManager manager;
    @Autowired
    private CityDao cityDao;

    private City city;

    @Before
    public void configure(){
        city = new City("SPb");

    }

@Test
    public void testAdd() {
        cityDao.add(city);
        assertEquals("SPb", cityDao.findAll().get(0).getName());
    }
@Test
    public void testRemove() {
        cityDao.add(city);
        int cityId = cityDao.findByName("SPb").get(0).getCityId();
        cityDao.remove(city);
        assertNull(manager.find(City.class, cityId));
    }
}