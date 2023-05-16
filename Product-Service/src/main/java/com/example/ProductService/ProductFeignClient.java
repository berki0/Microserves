package com.example.ProductService;

import com.example.ProductService.Model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductFeignClient {
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id);
}
