package com.example.OrderService.Controller;

import com.example.OrderService.ClientConfig.MicroserviceClientProduct;
import com.example.OrderService.Model.Order;
import com.example.OrderService.Service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/order")
@RestController
@AllArgsConstructor
public class OrderController {
    OrderService orderService;
    MicroserviceClientProduct microserviceClientProduct;

    @GetMapping("/get")
    public ResponseEntity getOrders() {
        return ResponseEntity.ok(orderService.ListAllOrders());
    }
    @PostMapping("/add/{productId}")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order, @PathVariable(name = "productId") Long productId) {
        return orderService.save(order, productId);
    }
    @DeleteMapping("delete/{orderID}")
    public ResponseEntity deleteOrder( @PathVariable(name = "orderID") Long orderID){
        return orderService.deleteOrder(orderID);
    }
    @PostMapping("/update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        return orderService.updateOrder(order);
    }
}
