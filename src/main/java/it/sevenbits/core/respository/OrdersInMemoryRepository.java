package it.sevenbits.core.respository;

import it.sevenbits.core.domain.Order;

import java.util.*;

public class OrdersInMemoryRepository implements OrdersRepository {
    private Map<UUID, Order> orders;

    public OrdersInMemoryRepository(final Map<UUID, Order> orders) {
        this.orders = Collections.unmodifiableMap(orders);
    }

    public OrdersInMemoryRepository(){
        this.orders = new HashMap<UUID, Order>();
    }

    @Override
    public Order save(final Order order) {
        Map<UUID, Order> modifiedOrders = new HashMap<UUID, Order>(orders);
        if (order.getId() == null) {
            order.setId(UUID.randomUUID());
        }
        modifiedOrders.put(order.getId(), order);
        this.orders = Collections.unmodifiableMap(modifiedOrders);

        return order;
    }

    @Override
    public Order find(UUID id) {
        return orders.get(id);
    }

    @Override
    public Map<UUID, Order> findAll() {
        return orders;
    }
}
