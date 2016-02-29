package com.grocerystore.hib;

import com.grocerystore.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.util.Properties;

/**
 * Created by Retman on 2016-02-29.
 */
public class HibernateUtil {

    public static Session buildSessionFactory() {

        Session session = null;
        try {
            Configuration configuration = new Configuration().configure();
            Properties prop = new Properties();
            prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/grocery_store");
            prop.setProperty("hibernate.connection.username", "root");
            prop.setProperty("hibernate.connection.password", "");
            prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

            configuration.setProperties(prop);
            configuration.addPackage("com.grocerystore.entities");
            configuration.addAnnotatedClass(Product.class);
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            session = sessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }
}
