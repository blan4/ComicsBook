package it.sevenbits.core.respository;

import it.sevenbits.core.domain.Order;
import it.sevenbits.core.mappers.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier(value = "orderPersistRepository")
public class OrderPersistRepository implements OrderRepository {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order save(final Order order) {
        orderMapper.save(order);
        return order;
    }

    @Override
    public Order find(Integer id) {
        return orderMapper.find(id);
    }

    public List<Order> findAll() {
        return orderMapper.findAll();
    }
}
