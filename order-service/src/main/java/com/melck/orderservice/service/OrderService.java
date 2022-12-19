package com.melck.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.melck.orderservice.common.Payment;
import com.melck.orderservice.common.TransactionRequest;
import com.melck.orderservice.common.TransactionResponse;
import com.melck.orderservice.entity.Order;
import com.melck.orderservice.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private RestTemplate template;

    @Autowired
    private OrderRepository repository;
    
    public TransactionResponse saveOrder(TransactionRequest request) {
        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());

        // rest call
        Payment paymentResponse = template.postForObject("http://localhost:8081/payments/doPayment", payment, Payment.class);
        
        response = paymentResponse.getPaymentStatus().equals("success")?"payment processing successful and order placed" : "there is a failure is payment api, order added to cart";
        
        repository.save(order);

        return new TransactionResponse(order,paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }
}
