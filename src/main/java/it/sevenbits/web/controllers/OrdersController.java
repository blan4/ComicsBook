package it.sevenbits.web.controllers;

import it.sevenbits.web.domain.JsonResponse;
import it.sevenbits.web.domain.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by Ilya on 15.07.2014.
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody JsonResponse create(@RequestBody Order order) {
        HashMap<String, String> message = new HashMap<String, String>(3);
        message.put("name", "can't be blank");
        message.put("email", "is not valid");
        message.put("message", "is too long");
        return new JsonResponse(true, message);
    }
}
