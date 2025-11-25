package com.example.Controllers;

import com.example.Models.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    public OrderController() {}

    @RequestMapping(path = "", method = RequestMethod.POST)
    public String create(@RequestBody Order order) {
        return OrderDataArray.add(order);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Order> getAll() {
        return OrderDataArray.getOrders();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Order findByID(@PathVariable int id) {
        return OrderDataArray.getById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Order update(@PathVariable Order order) {
        return OrderDataArray.update(order);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public static String deleteByID(@PathVariable int id) {
        return OrderDataArray.deleteById(id);
    }
}
