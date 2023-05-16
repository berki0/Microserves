package com.example.OrderService.Model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String fullName;
    private String username;
    private Long productId;
}


