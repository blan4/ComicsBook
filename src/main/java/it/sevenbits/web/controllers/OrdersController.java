package it.sevenbits.web.controllers;

import it.sevenbits.core.services.OrderService;
import it.sevenbits.web.domain.JsonResponse;
import it.sevenbits.web.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody JsonResponse create(@Valid @RequestBody Order order, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            HashMap<String, String> message = new HashMap<String, String>(bindingResult.getErrorCount());
            for (Object object : bindingResult.getAllErrors()) {
                if (object instanceof FieldError) {
                    FieldError fieldError = (FieldError) object;
                    message.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
            }
            return new JsonResponse(true, message);
        }

        orderService.createOrder(order.toDomain());
        return new JsonResponse(false, null);
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Order> index(){
        Map<UUID, it.sevenbits.core.domain.Order> coreOrders = orderService.findAll();
        List<Order> orders = new ArrayList<Order>(coreOrders.size());
        for (it.sevenbits.core.domain.Order coreOrder : coreOrders.values()) {
            orders.add(new Order(coreOrder));
        }

        return orders;
    }
}
