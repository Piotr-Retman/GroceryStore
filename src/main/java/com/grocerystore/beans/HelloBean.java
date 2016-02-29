package com.grocerystore.beans;


import com.grocerystore.entities.Product;
import com.grocerystore.impl.ProductImpl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.math.BigDecimal;

/**
 * Created by Retman on 2016-02-12.
 */
@ManagedBean(name = "helloWorld", eager = true)
@RequestScoped
public class HelloBean {

    public String name = "Piotr";
    public String priceProduct = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public void getData(){
        ProductImpl product = new ProductImpl();
        Product productById = product.getProductById(1);
        productById.setPrice(new BigDecimal(20));
        priceProduct = productById.getPrice().toString();

    }
}
