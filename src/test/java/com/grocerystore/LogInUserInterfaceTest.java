package com.grocerystore;

import com.grocerystore.entities.User;
import com.grocerystore.impl.userimpl.UserImpl;
import com.grocerystore.servlets.MyServlet;
import org.junit.Test;
import org.mockito.InjectMocks;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.mock;

/**
 * Created by retman on 11.07.16.
 */
public class LogInUserInterfaceTest {

    @Test
    public void logInUserTest() {
        HttpServlet mockedServlet = mock(HttpServlet.class);
        HttpServletRequest mockedRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockedResponse = mock(HttpServletResponse.class);
        MyServlet myServlet = mock(MyServlet.class);
    }

    @Test
    public void getUserDataFromDBTest() {
        UserImpl user = new UserImpl();
        User u = user.retrieveOneUserBasedOnId(1);
        String firstName = u.getFirstName();
        System.out.println(firstName);
    }
}
