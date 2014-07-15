package it.sevenbits.web.controllers;

import it.sevenbits.web.domain.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ilya on 15.07.2014.
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Order create() {
        return new Order("a","b","c");
    }
}
