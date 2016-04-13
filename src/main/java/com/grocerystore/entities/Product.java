package com.grocerystore.entities;

import javax.persistence.*;
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

    @Column(name = "type_product")
    private String typeProduct;
    private BigDecimal price;
    private String provider;
    private String name;

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
