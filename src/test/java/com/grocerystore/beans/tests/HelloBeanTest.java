package com.grocerystore.beans.tests;

import com.grocerystore.beans.HelloBean;
import com.grocerystore.entities.Product;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by retman on 06.07.16.
 */
public class HelloBeanTest extends TestCase {


    @Test
    public void testForMethod() {
        HelloBean hb = new HelloBean();
        Mockito
        List<Product> allProductsList = hb.getAllProductsList();

    }

}