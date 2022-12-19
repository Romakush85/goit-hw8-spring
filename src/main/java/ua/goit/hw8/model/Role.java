package ua.goit.hw8.model;


import java.util.UUID;
public enum Role {
    ROLE_USER ("ROLE_USER"),
    ROLE_ADMIN ("ROLE_ADMIN");

    final String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
