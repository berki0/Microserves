package com.example.FeingClientService.OrderClient;

import com.example.OrderService.Model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "order-service",url = "http://localhost:8082/order")
public interface OrderServiceClient {

    @GetMapping("/get")
    public ResponseEntity getOrders();

    @PostMapping("/add/{productId}")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order, @PathVariable(name = "productId") Long productId);

    @DeleteMapping("delete/{orderID}")
    public ResponseEntity deleteOrder( @PathVariable(name = "orderID") Long orderID);

    @PostMapping("/update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order);
}
