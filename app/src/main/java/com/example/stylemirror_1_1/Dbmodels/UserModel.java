package com.example.stylemirror_1_1.Dbmodels;

public class UserModel {
    public  String Username;
    public String Email;

    public UserModel(String username, String email, String password) {
        Username = username;
        Email = email;
        Password = password;
    }

    public UserModel() {
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String Password;
}
