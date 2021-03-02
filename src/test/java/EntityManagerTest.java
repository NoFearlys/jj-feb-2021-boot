import com.lesson3.jjfeb2021.models.DAO.DaoTestConfig;
import com.lesson3.jjfeb2021.models.City;
import com.lesson3.jjfeb2021.models.Client;
import com.lesson3.jjfeb2021.models.Model;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoTestConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class EntityManagerTest {
    @Autowired
    private EntityManagerFactory factory;
    @Autowired
    private EntityManager manager;



    @Test
    public void smokeTest() {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        manager = factory.createEntityManager();

        try {
            manager.getTransaction().begin();
            City city = new City("Санкт-Петербург");
            Model model = new Model("Альтера", "2.0.Н", 3500, "0F 24", "27 10");
            Client client = new Client("Александр", city, "СПБ, Есенина, 26", 9443824, model);
            manager.persist(client);
            manager.getTransaction().commit();
        } finally {
            manager.close();
            factory.close();
        }
    }
}