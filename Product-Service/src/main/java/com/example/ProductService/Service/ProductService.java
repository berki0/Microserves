package com.example.ProductService.Service;

import com.example.ProductService.DTO.ProductDTO;
import com.example.ProductService.Mapper.ProductMapper;
import com.example.ProductService.Model.Product;
import com.example.ProductService.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProductService {
    final ProductRepository productRepository;
    final ProductMapper productMapper;

    public ResponseEntity<Stream<ProductDTO>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll().stream().map(productMapper));
    }

    public ResponseEntity getProductByID(Long id) {
       Optional<Product> product=productRepository.findById(id);
       if (product.isEmpty()) {
           return ResponseEntity.ok("Not Found Product");
       }
        return ResponseEntity.ok(productRepository.findById(id).map(productMapper));
    }


    public ResponseEntity<ProductDTO> addProduct(Product product) {
        productRepository.save(product);
        ProductDTO productDTO=productMapper.apply(product);
        return ResponseEntity.ok(productDTO);
    }

    public ResponseEntity<String> deleteProductByID(Long id) {
        for (int i = 0; i < productRepository.findAll().toArray().length; i++) {
            if (id.equals(productRepository.findAll().get(i).getId())) {
                productRepository.deleteById(id);
                return ResponseEntity.ok("Product deleted !");
            }
        }
        return ResponseEntity.ok("Product Not Found !");
    }

    public ResponseEntity<String> deleteProductByProduct(Product product) {
        productRepository.delete(product);
        return ResponseEntity.ok("Product deleted !");
    }

    public ResponseEntity<String> editProduct(Product product) {
        productRepository.save(product);
        return ResponseEntity.ok("your " + product.toString() + " Saved");
    }


}
