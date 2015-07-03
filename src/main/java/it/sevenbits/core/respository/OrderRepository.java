package it.sevenbits.core.respository;

import it.sevenbits.core.domain.Order;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface OrderRepository {
    Order save(final Order order);
    Order find(final Integer id);
    List<Order> findAll();
}
