package com.example.OrderService.Controller;

import com.example.OrderService.Repository.OrderRepository;
import com.example.ProductService.ProductFeignClient;
import com.example.ProductService.Model.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/order")
@RestController
@AllArgsConstructor
public class OrderController {
    private OrderRepository orderRepository ;

    @GetMapping("/get")
    public String get(){
        return orderRepository.findAll().toString();
    }
    @GetMapping(value = "/add/{productID}")
    public Product getProduct(ProductFeignClient productFeignClient, @PathVariable (name = "productID")Long productId) {
        return productFeignClient.getProductById(productId);
    }
}
