package ua.goit.hw8.model;


import java.util.UUID;
public enum Role {
    USER ("USER"),
    ADMIN ("ADMIN");

    final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }




}
