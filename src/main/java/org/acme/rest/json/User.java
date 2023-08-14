package org.acme.rest.json;

public class User {

    public String name;
    public String description;

    public User() {
    }

    public User(String name, String description) {
        this.name = name;
        this.description = description;
    }
}