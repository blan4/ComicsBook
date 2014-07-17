package it.sevenbits.core.respository;

import it.sevenbits.core.domain.Order;

import java.util.*;

/**
 * Created by Ilya on 17.07.2014.
 */
public class OrdersInMemoryRepository implements OrdersRepository {
    private Map<UUID, Order> orders;

    public OrdersInMemoryRepository(final Map<UUID, Order> orders) {
        this.orders = Collections.unmodifiableMap(orders);
    }

    @Override
    public Order save(final Order order) {
        Map<UUID, Order> modifiedOrders = new HashMap<UUID, Order>(orders);
        modifiedOrders.put(order.getId(), order);
        this.orders = Collections.unmodifiableMap(modifiedOrders);

        return order;
    }

    @Override
    public Order find(UUID id) {
        return null;
    }

    @Override
    public Map<UUID, Order> findAll() {
        return orders;
    }
}
