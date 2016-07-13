package com.grocerystore.except;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by retman on 13.07.16.
 */
public class UserManagementException extends Exception {

    public Logger logger = Logger.getAnonymousLogger();

    public UserManagementException() {
        super();
    }

    public UserManagementException(String message) {
        logger.log(Level.WARNING, message);
    }
}
