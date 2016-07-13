package com.grocerystore.beans;

import com.grocerystore.ejb.UserService;
import com.grocerystore.entities.Users;
import com.grocerystore.except.UserManagementException;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.io.Serializable;

/**
 * Created by retman on 13.07.16.
 */
@ManagedBean(name = "loginLogoutBean", eager = true)
@SessionScoped
public class LoginLogoutBean implements Serializable {

    private String username;
    private String password;

    public String login() throws UserManagementException {
        UserService userService = new UserService();
        Users users = userService.getUserByUsernameAndPasswrd(username, password);
        FacesContext context = FacesContext.getCurrentInstance();

        if (users == null) {
            context.addMessage(null, new FacesMessage("Unknown login, try again"));
            username = null;
            password = null;
            return null;
        } else {
            context.getExternalContext().getSessionMap().put("users", users.getFirstName() + " " + users.getSurname());
            return "/user.xhtml?faces-redirect=true";
        }
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
