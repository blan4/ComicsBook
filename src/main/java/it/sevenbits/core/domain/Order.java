package it.sevenbits.core.domain;

public class Order {
    private Integer id;
    private String email;
    private String name;
    private String message;

    public Order(Integer id, String email, String name, String message) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.message = message;
    }

    public Order() {
        this.id = null;
        this.email = null;
        this.name = null;
        this.message = null;
    }

    @Override
    public String toString() {
        return String.format(
                "Order[id=%d, email='%s', name='%s', message='%s']",
                id, email, name, message);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
