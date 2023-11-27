package com.example.demo.order;

import com.example.demo.meal.Meal;
import com.example.demo.meal.MealRepository;
import com.example.demo.meal.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final MealRepository mealRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, MealRepository mealRepository){
        this.orderRepository = orderRepository;
        this.mealRepository = mealRepository;
    }

    public Order createOrder(String customerName, String mealName){
        Meal meal = mealRepository.findByName(mealName);

        if(meal == null){
            throw new RuntimeException("Yemek Bulunamadı.");
        }

        Order order = new Order(customerName, meal);
        return orderRepository.save(order);
    }

    public List<Order> getOrderByCustomer(String customerName){
        return orderRepository.findByCustomerName(customerName);
    }

    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
}
