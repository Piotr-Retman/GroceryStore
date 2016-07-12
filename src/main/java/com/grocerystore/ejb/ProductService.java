package com.grocerystore.ejb;

import com.grocerystore.ejb.ejbinterface.ProductServiceInterface;
import com.grocerystore.entities.Product;
import com.grocerystore.impl.prodimpl.ProductImpl;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Retman on 2016-02-29.
 */
@Stateless
public class ProductService implements ProductServiceInterface {

    public Product getById(int id) {
        ProductImpl product = new ProductImpl();
        Product productById = product.getProductById(id);
        return productById;
    }

    public List<Product> getAllProducts(){
        List<Product> listOfProducts = new ArrayList<Product>();
        ProductImpl product = new ProductImpl();
        List<Product> products = product.getProducts();
        return products;
    }
}
