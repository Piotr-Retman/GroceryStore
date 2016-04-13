package com.grocerystore.beans;


import com.grocerystore.ejb.ProductService;
import com.grocerystore.entities.Product;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Retman on 2016-02-12.
 */
@ManagedBean(name = "helloWorld", eager = true)
@SessionScoped
public class HelloBean {

    public String name = "Piotr";
    private String priceProduct = "";
    private int id;
    List<Product> allProductsList;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getAllProductsList() {
        return allProductsList;
    }

    public void setAllProductsList(List<Product> allProductsList) {
        this.allProductsList = allProductsList;
    }

    public void loadPriceData(int id) {
        ProductService productService = new ProductService();
        Product product = productService.getById(id);
        setPriceProduct(product.getPrice().toString());
    }

    public void forTest() {
        ProductService productService = new ProductService();
        Product product = productService.getById(id);
        setPriceProduct(product.getPrice().toString());
    }

    public void allProducts(){
        ProductService productService = new ProductService();
        List<Product> allProducts = productService.getAllProducts();
        setAllProductsList(allProducts);
    }

}
