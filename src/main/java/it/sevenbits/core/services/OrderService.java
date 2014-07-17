package it.sevenbits.core.services;

import it.sevenbits.core.domain.Order;
import it.sevenbits.core.respository.OrdersRepository;

import java.util.UUID;

/**
 * Created by Ilya on 17.07.2014.
 */
public class OrderService {
    private final OrdersRepository repository;

    public OrderService(final OrdersRepository repository) {
        this.repository = repository;
    }

    public Order createOrder(Order order) {
        if (order.getId() == null) {
            order.setId(UUID.randomUUID());
        }
        return repository.save(order);
    }
}
