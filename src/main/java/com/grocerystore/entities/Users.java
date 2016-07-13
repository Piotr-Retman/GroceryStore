package com.grocerystore.entities;

import javax.persistence.*;

/**
 * Created by retman on 11.07.16.
 */
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "find",
                query = "select users.user_id,users.username,users.user_type,users.first_name,users.surname from users where users.username = :username and users.passwd = :password"
        )
})
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue
    @Column(name="user_id")
    private int userId;
    @Column(name="user_type")
    private String userType;

    @Column(name="username")
    private String userName;

    @Transient
    @Column(name="passwd")
    private String passwd;

    @Column(name="first_name")
    private String firstName;

    private String surname;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
