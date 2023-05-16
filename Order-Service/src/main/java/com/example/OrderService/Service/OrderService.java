package com.example.OrderService.Service;

import com.example.OrderService.ClientConfig.MicroserviceClientProduct;
import com.example.OrderService.Model.Order;
import com.example.OrderService.Repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class OrderService {
     OrderRepository orderRepository;
     MicroserviceClientProduct microserviceClientProduct;

     public OrderService(OrderRepository orderRepository) {
          this.orderRepository = orderRepository;
     }

     public ResponseEntity<Order> save(@RequestBody Order order, @PathVariable Long productID){
          order.setProductId(microserviceClientProduct.invokeMicroserviceAndGetObjectId(productID));
          orderRepository.save(order);
          return ResponseEntity.ok(order);
     }
     public ResponseEntity ListAllOrders(){
          return ResponseEntity.ok(orderRepository.findAll());
     }

     public ResponseEntity deleteOrder(Long orderId){
          orderRepository.deleteById(orderId);
          return (ResponseEntity) ResponseEntity.status(HttpStatus.ACCEPTED);
     }

     public ResponseEntity<Order> updateOrder(@RequestBody Order order){
          return ResponseEntity.ok(orderRepository.save(order));
     }
}
