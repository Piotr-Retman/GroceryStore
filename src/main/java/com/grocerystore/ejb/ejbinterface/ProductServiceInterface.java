package com.grocerystore.ejb.ejbinterface;

import com.grocerystore.entities.Product;

import java.util.List;

/**
 * Created by Retman on 2016-02-29.
 */
public interface ProductServiceInterface {
    Product getById(int id);
    List<Product> getAllProducts();
}
