package com.example.ProductService.Controller;

import com.example.ProductService.DTO.ProductDTO;
import com.example.ProductService.Model.Product;
import com.example.ProductService.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public ResponseEntity<String> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/productId/{id}")
    public ResponseEntity getProductByID(@PathVariable(name = "id") Long id) {
        return productService.getProductByID(id);
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<String> deleteProductByID(@PathVariable(name = "id") Long id) {
        return productService.deleteProductByID(id);
    }


    @PostMapping("/edit")
    public ResponseEntity<String> editProduct(@RequestBody Product product) {
        return productService.editProduct(product);
    }
}
