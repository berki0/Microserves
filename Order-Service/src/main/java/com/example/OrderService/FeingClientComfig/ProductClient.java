package com.example.OrderService.FeingClientComfig;

import com.example.ProductService.DTO.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "orderProduct-app")
public interface ProductClient {
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id")Long id);
    @GetMapping("/products/{id}")
    public ResponseEntity<List<ProductDTO>> getProductsByOrderId(@PathVariable("id")Long id);
}