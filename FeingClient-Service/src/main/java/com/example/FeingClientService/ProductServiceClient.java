package com.example.FeingClientService;
import com.example.OrderService.Model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@FeignClient(value = "product-service",url = "http://localhost:8081/product")
public
interface ProductServiceClient {

    @GetMapping("/list")
    public ResponseEntity getAllProducts();

    @GetMapping("/productId/{id}")
    public ResponseEntity getProductByID(@PathVariable(name = "id") Long id);

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody Product product);

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<String> deleteProductByID(@PathVariable(name = "id") Long id);

    @PostMapping("/edit")
    public ResponseEntity<String> editProduct(@RequestBody Product product);

}