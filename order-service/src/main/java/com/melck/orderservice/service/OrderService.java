package com.melck.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melck.orderservice.entity.Order;
import com.melck.orderservice.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    
    public Order saveOrder(Order order) {
        return repository.save(order);
    }
}
