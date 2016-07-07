package com.grocerystore;

import com.grocerystore.beans.HelloBean;
import com.grocerystore.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.isNull;

/**
 * Created by retman on 06.07.16.
 */
@RunWith(JUnit4.class)
public class HelloBeanTest {

    private SessionFactory sessionFactory;
    private Session session = null;

    @Before
    public void before() {

        Configuration configuration = new Configuration().configure();
        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        prop.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        prop.setProperty("hibernate.hbm2ddl.auto", "create");
        configuration.setProperties(prop);
        configuration.addPackage("com.grocerystore.entities");
        configuration.addAnnotatedClass(Product.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
    }

    @Test
    public void testForMethod() {
        HelloBean hb = new HelloBean();
        hb.allProducts();
        List<Product> allProductsList = hb.getAllProductsList();
        assertThat("All product list is not empty",allProductsList.size()!=0,is(true));

    }

    @Test
    public void testMethodForTest(){
        HelloBean hb = new HelloBean();
        hb.setId(1);
        hb.forTest();
        hb.loadPriceData(1);
        String priceProduct = hb.getPriceProduct();
        assertThat("Price for product is not empty",priceProduct,is(not(isNull())));
    }


}