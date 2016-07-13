package com.grocerystore;

import com.grocerystore.ejb.UserService;
import com.grocerystore.entities.Users;
import com.grocerystore.except.UserManagementException;
import com.grocerystore.impl.userimpl.UserImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import javax.ejb.EJB;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.notNull;

/**
 * Created by retman on 11.07.16.
 */
public class LogInUsersInterfaceTest {

    UserService userService;

    @Test(expected = UserManagementException.class)
    public void getUserDataFromDBTestWithException() throws UserManagementException {
        UserImpl user = new UserImpl();
        Users u = user.retrieveOneUserBasedOnId("10");
    }

    @Test
    public void getUserDataFromDBTest() throws UserManagementException {
        UserImpl user = new UserImpl();
        Users u = user.retrieveOneUserBasedOnId("1");
        String firstName = u.getFirstName();
        assertThat("First name is not null", firstName, is("John"));
    }

    @Test
    public void ejbUserLoginTest() throws UserManagementException {
        userService = new UserService();
        Users userByUsernameAndPasswrd = userService.getUserByUsernameAndPasswrd("john", "password");
        Users userById = userService.getUserById("1");
        String firstName = userByUsernameAndPasswrd.getUserName();
        assertThat("User name is John",firstName,is("john"));
    }
}
