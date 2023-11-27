package com.example.demo.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestParam String customerName, @RequestParam String mealName){
        Order createdOrder = orderService.createOrder(customerName, mealName);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @PostMapping("/getByCustomer")
    public ResponseEntity<List<Order>> getOrderByCustomer(@RequestParam String customerName){
        List<Order> orders = orderService.getOrderByCustomer(customerName);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Order>> listOrders(){
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
