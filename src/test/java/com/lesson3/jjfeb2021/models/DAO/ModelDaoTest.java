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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoTestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ModelDaoTest {

    @Autowired
    private EntityManager manager;
    @Autowired
    private ModelDao modelDao;

    private Model model;



    @Before
    public void configure(){
        BaseFiller baseFiller = new BaseFiller();
        baseFiller.fill(manager);

        model = new Model("Хонкон1", "2.0.H", 3500, "00F1", "270F");
    }

    @Test
    public void findAllModels() {
        assertEquals(6, modelDao.findAllModels().size());
    }

    @Test
    public void findByVersion() {
        List<Model> results= modelDao.findByVersion("2.0.H");

        for(Model m : results){
            assertEquals("2.0.H", m.getVersion());
        }
        assertEquals(3, results.size());
    }

    @Test
    public void findByName() {
        List<Model> results= modelDao.findByName("Стандартный");

        for(Model m : results){
            assertEquals("Стандартный", m.getName());
        }
        assertEquals(2, results.size());
    }

    @Test
    public void add(){
        modelDao.add(model);
        assertEquals("Хонкон1", modelDao.findByName("Хонкон1").get(0).getName());
    }

    @Test
    public void remove(){
        int modelId = model.getModelId();
        modelDao.remove(model);
        assertNull(manager.find(Model.class, modelId));
    }
}
