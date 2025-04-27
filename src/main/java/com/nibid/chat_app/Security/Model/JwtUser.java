package com.nibid.chat_app.Security.Model;


public class JwtUser {

    private static String userName;
    private static Long id;
    private static String role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        JwtUser.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        JwtUser.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        JwtUser.role = role;
    }
}
