package it.sevenbits.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ilya on 15.07.2014.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "home/index";
    }
}
