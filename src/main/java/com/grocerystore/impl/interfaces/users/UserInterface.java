package com.grocerystore.impl.interfaces.users;

import com.grocerystore.entities.Users;
import com.grocerystore.except.UserManagementException;

/**
 * Created by retman on 11.07.16.
 */
public interface UserInterface {
    Users retrieveOneUserBasedOnId(String id) throws UserManagementException;

    Users retrieveOneUserBasedOnUsernameAndPassword(String username, String password) throws UserManagementException;
}
