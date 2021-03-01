package DAO;


import com.lesson3.jjfeb2021.models.DAO.ModelDao;
import com.lesson3.jjfeb2021.models.Model;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoTestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ModelDaoTest {

    @Autowired
    private EntityManager manager;
    @Autowired
    private ModelDao modelDao;

    private Model model;
    private Model model1;
    private Model model2;
    private Model model3;
    private Model model4;
    private Model model5;
    private Model model6;


    @Before
    public void configure(){
        modelDao = new ModelDao(manager);
        model = new Model("Стандартный", "2.0.H", 3500, "00F1", "270F");
        model1 = new Model("Стандартный", "2.1.H", 3500, "00F1", "270F");
        model2 = new Model("Черный", "2.3.H", 3500, "00F1", "270F");
        model3 = new Model("Белый", "2.1.H", 3500, "00F1", "270F");
        model4 = new Model("Дабло", "4.0.H", 10000, "00F1", "270F");
        model5 = new Model("Хонкон", "2.0.H", 3500, "00F1", "270F");
        model6 = new Model("Хонкон1", "2.0.H", 3500, "00F1", "270F");


        manager.getTransaction().begin();
        manager.persist(model);
        manager.persist(model1);
        manager.persist(model2);
        manager.persist(model3);
        manager.persist(model4);
        manager.persist(model5);
        manager.getTransaction().commit();
    }

    @Test
    public void findAllModels() {

    }

    @Test
    public void findByVersion(String version) {

    }

    @Test
    public void findByName(String name) {

    }

    @Test
    public void add(Model model){

    }

    @Test
    public void remove(Model model){

    }
}
