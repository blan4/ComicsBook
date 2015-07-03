package it.sevenbits.core.respository;

import it.sevenbits.core.domain.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Qualifier(value = "orderInMemoryRepository")
public class OrderInMemoryRepository implements OrderRepository {
    private final Map<Integer, Order> orders;
    private final AtomicInteger sequence;

    public OrderInMemoryRepository(){
        orders = new HashMap<>();
        sequence = new AtomicInteger(0);
    }

    @Override
    public Order save(final Order order) {
        order.setId(sequence.addAndGet(1));
        orders.put(order.getId(), order);
        return order;
    }

    @Override
    public Order find(Integer id) {
        return orders.get(id);
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orders.values());
    }
}
