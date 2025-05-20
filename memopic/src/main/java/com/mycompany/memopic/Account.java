package com.mycompany.memopic;

public abstract class Account {
    int id;
    String username;
    String email;
    String password;

    public Account(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    abstract void showWelcomeMessage();
}
   
