package com.grocerystore.impl.interfaces.users;

import com.grocerystore.entities.User;

/**
 * Created by retman on 11.07.16.
 */
public interface UserInterface {
    User retrieveOneUserBasedOnId(int id);
}
