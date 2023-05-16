package com.example.FeingClientService;
import com.example.OrderService.Model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductControllerClient {
    ProductServiceClient productServiceClient;

    public ProductControllerClient(ProductServiceClient productServiceClient) {
        this.productServiceClient = productServiceClient;
    }

    @GetMapping("/getAll")
    public ResponseEntity getAllProducts() {
        return productServiceClient.getAllProducts();
    }

    @GetMapping("/productId/{id}")
    public ResponseEntity getProductByID(@PathVariable(name = "id") Long id) {
        return productServiceClient.getProductByID(id);
    }

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody Product product) {
        return productServiceClient.addProduct(product);
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<String> deleteProductByID(@PathVariable(name = "id") Long id) {
        return productServiceClient.deleteProductByID(id);
    }

    @PostMapping("/edit")
    public ResponseEntity<String> editProduct(@RequestBody Product product) {
        return productServiceClient.editProduct(product);
    }
}