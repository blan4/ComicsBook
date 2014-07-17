package it.sevenbits.web;

import it.sevenbits.core.respository.OrdersInMemoryRepository;
import it.sevenbits.core.services.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Ilya on 15.07.2014.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
    @Bean
    public OrderService orderService(){
        return new OrderService(new OrdersInMemoryRepository());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
