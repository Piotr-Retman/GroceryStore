package com.grocerystore.ejb.ejbinterface;

import com.grocerystore.entities.Users;
import com.grocerystore.except.UserManagementException;

/**
 * Created by retman on 13.07.16.
 */
public interface UserServiceInterface {
    Users getUserById(String id) throws UserManagementException;
    Users getUserByUsernameAndPasswrd(String username, String password) throws UserManagementException;
}
