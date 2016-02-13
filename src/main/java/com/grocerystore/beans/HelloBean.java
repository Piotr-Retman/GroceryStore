package com.grocerystore.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by Retman on 2016-02-12.
 */
@ManagedBean(name = "helloWorld", eager = true)
@RequestScoped
public class HelloBean {


    public String name = "Piotr";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
