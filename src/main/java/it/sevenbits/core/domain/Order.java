package it.sevenbits.core.domain;

import java.util.UUID;

/**
 * Created by Ilya on 17.07.2014.
 */
public class Order {
    private UUID id;
    private String email;
    private String name;
    private String message;

    public Order(UUID id, String email, String name, String message) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.message = message;
    }

    public Order(String email, String name, String message) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.name = name;
        this.message = message;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
