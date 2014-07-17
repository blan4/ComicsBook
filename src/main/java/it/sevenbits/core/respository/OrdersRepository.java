package it.sevenbits.core.respository;

import it.sevenbits.core.domain.Order;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Ilya on 17.07.2014.
 */
public interface OrdersRepository {
    Order save(final Order order);
    Order find(UUID id);
    Map<UUID, Order> findAll();
}