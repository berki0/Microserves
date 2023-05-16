package com.example.ProductService.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@RequiredArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private  String description;
    private double price;


}
