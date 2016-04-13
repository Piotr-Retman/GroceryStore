package com.grocerystore.dao;

import com.grocerystore.entities.Product;
import com.grocerystore.impl.ProductImpl;

import java.math.BigDecimal;

/**
 * Created by Retman on 2016-04-13.
 */
public class ProductDAO {
    public String getData(int id) {
        ProductImpl product = new ProductImpl();
        Product productById = product.getProductById(id);
        productById.setPrice(new BigDecimal(20));
        String priceProduct = productById.getPrice().toString();
        return priceProduct;

    }
}
