package com.grocerystore.ejb;

import com.grocerystore.ejb.ejbinterface.UserServiceInterface;
import com.grocerystore.entities.Users;
import com.grocerystore.except.UserManagementException;
import com.grocerystore.impl.userimpl.UserImpl;

import javax.ejb.Stateful;

/**
 * Created by retman on 13.07.16.
 */
@Stateful
public class UserService implements UserServiceInterface {

    public Users getUserById(String id) throws UserManagementException {
        UserImpl usrImpl = new UserImpl();
        return usrImpl.retrieveOneUserBasedOnId(id);
    }

    public Users getUserByUsernameAndPasswrd(String username, String password) throws UserManagementException {
        UserImpl usrImpl = new UserImpl();
        return usrImpl.retrieveOneUserBasedOnUsernameAndPassword(username, password);
    }

}
