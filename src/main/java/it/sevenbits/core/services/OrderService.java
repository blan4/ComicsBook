package it.sevenbits.core.services;

import it.sevenbits.core.domain.Order;
import it.sevenbits.core.respository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    @Qualifier(value = "orderPersistRepository")
    private OrderRepository repository;

    public Order createOrder(Order order) {
        return repository.save(order);
    }

    public List<Order> findAll() {
        return repository.findAll();
    }
}
