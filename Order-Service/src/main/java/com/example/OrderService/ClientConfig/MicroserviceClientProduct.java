package com.example.OrderService.ClientConfig;

import com.example.ProductService.Model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MicroserviceClientProduct {

    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;

    public MicroserviceClientProduct() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public Long invokeMicroserviceAndGetObjectId(Long productId) {
        String endpointUrl = "http://localhost:8081/product/productIdForOrder/" + productId; // Подменете с реалния URL адрес
        HttpEntity<?> requestEntity = new HttpEntity<>(null);

        ResponseEntity<Product> response = restTemplate.exchange(
                endpointUrl,
                HttpMethod.GET,
                requestEntity,
                Product.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            Product responseBody = response.getBody();
            assert responseBody != null;
            com.example.OrderService.Model.Product product =new com.example.OrderService.Model.Product();
            product.setId(responseBody.getId());
            return product.getId();

        } else {
            throw new RuntimeException("Грешка при извикването на микросервиса. Код на грешка: " + response.getStatusCodeValue());
        }
    }
}
