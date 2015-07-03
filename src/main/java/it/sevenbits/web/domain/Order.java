package it.sevenbits.web.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.UUID;

public class Order {
    private final UUID id;

    @NotBlank(message = "can't be blank")
    @Size(min=2, message = "can't be less then 2 or more then 30 symbols")
    private final String name;


    @NotBlank(message = "can't be blank")
    @Size(min=5, max=255, message = "can't be less then 5 or more 255 symbols")
    @Pattern(regexp = "^(?:[a-zA-Z0-9_'^&/+-])+(?:\\.(?:[a-zA-Z0-9_'^&/+-])+)" +
            "*@(?:(?:\\[?(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))\\.)" +
            "{3}(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\]?)|(?:[a-zA-Z0-9-]+\\.)" +
            "+(?:[a-zA-Z]){2,}\\.?)$", message = "wrong pattern")
    private final String email;

    @Size(max=1000, message = "must be less then 1000 symbols")
    private final String message;

    public Order(String name, String email, String message) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.message = message;
    }
    public Order(){
        this.id = UUID.randomUUID();
        this.name = null;
        this.email = null;
        this.message = null;
    } // dummy constructor

    public Order(it.sevenbits.core.domain.Order coreOrder) {
        this.id = coreOrder.getId();
        this.name = coreOrder.getName();
        this.email = coreOrder.getEmail();
        this.message = coreOrder.getMessage();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public it.sevenbits.core.domain.Order toDomain() {
        return new it.sevenbits.core.domain.Order(email, name, message);
    }

    public UUID getId() {
        return id;
    }
}
