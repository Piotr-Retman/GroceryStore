package com.grocerystore.impl;


import com.grocerystore.entities.Product;
import com.grocerystore.hib.HibernateUtil;
import com.grocerystore.impl.interfaces.ProductInterface;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Retman on 2016-02-13.
 */
public class ProductImpl implements ProductInterface {

    public Product getProductById(int id) {

        Session session = HibernateUtil.buildSessionFactory();
        session.beginTransaction();
        Product product = (Product) session.get(Product.class, id);
        session.close();
        return product;
    }

    public List<Product> getProducts() {
        Session session = HibernateUtil.buildSessionFactory();
        session.beginTransaction();
        List<Product> list = session.createCriteria(Product.class).list();
        session.close();
        return list;
    }

}
