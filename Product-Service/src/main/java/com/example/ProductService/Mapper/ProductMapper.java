package com.example.ProductService.Mapper;

import com.example.ProductService.DTO.ProductDTO;
import com.example.ProductService.Model.Product;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.function.Function;
@Service
public class ProductMapper implements Function<Product, ProductDTO> {
    @Override
    public ProductDTO apply(Product product) {
        return new ProductDTO(
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
