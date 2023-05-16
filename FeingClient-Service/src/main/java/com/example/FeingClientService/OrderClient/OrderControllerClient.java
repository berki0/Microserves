package com.example.FeingClientService.OrderClient;

import com.example.OrderService.Model.Order;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderControllerClient {
    OrderServiceClient orderServiceClient;

    public OrderControllerClient(OrderServiceClient orderServiceClient) {
        this.orderServiceClient = orderServiceClient;
    }
    @GetMapping("/get")
    public ResponseEntity getOrders(){
        return ResponseEntity.ok(orderServiceClient.getOrders());
    }

    @PostMapping("/add/{productId}")
    public ResponseEntity saveOrder(@RequestBody Order order, @PathVariable(name = "productId") Long productId){
        return orderServiceClient.saveOrder(order,productId);
    }

    @DeleteMapping("delete/{orderID}")
    public ResponseEntity deleteOrder( @PathVariable(name = "orderID") Long orderID){
        return new ResponseEntity<>(orderServiceClient.deleteOrder(orderID),HttpStatusCode.valueOf(200));
    }

    @PostMapping("/update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
       return new ResponseEntity(orderServiceClient.updateOrder(order), HttpStatusCode.valueOf(200));
    }



}
