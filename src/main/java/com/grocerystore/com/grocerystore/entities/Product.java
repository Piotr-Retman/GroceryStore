package com.grocerystore.com.grocerystore.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by Retman on 2016-02-13.
 */
@Entity
@Table( name = "product" )
public class Product {

    @Id
    @GeneratedValue
    private Integer id_product;

    private String type_product;
    private BigDecimal price;
    private String provider;

    public String getType_product() {
        return type_product;
    }

    public void setType_product(String type_product) {
        this.type_product = type_product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }
}
