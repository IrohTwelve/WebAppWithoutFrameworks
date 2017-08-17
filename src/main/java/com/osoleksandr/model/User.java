package com.osoleksandr.model;

import java.util.HashSet;
import java.util.Set;

public class User {

    private Integer id;
    private String userName;
    private String password;
    private String token;
    private String email;
    private boolean iAmAdmin;
    private Set<Roles> roles = new HashSet<Roles>();

    public User(Integer id, String userName, String password, String token, String email, boolean iAmAdmin, Set<Roles> roles) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.token = token;
        this.email = email;
        this.iAmAdmin = iAmAdmin;
        this.roles = roles;
    }

    public User(String userName, String password, String token, String email) {
        this.userName = userName;
        this.password = password;
        this.token = token;
        this.email = email;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

    public boolean isiAmAdmin() {
        return iAmAdmin;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
