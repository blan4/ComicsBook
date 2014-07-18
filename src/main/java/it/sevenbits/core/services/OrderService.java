package it.sevenbits.core.services;

import it.sevenbits.core.domain.Order;
import it.sevenbits.core.respository.OrdersRepository;

import java.util.Map;
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
        return repository.save(order);
    }

    public Map<UUID, Order> findAll() {
        return repository.findAll();
    }
}
