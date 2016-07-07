package com.grocerystore.interfaces;

import com.grocerystore.entities.Product;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by Retman on 2016-02-13.
 */
public interface ProductInterface {
    Product getProductById(int id);
    List<Product> getProducts();
}
