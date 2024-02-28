package com.inditex.general.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@ToString
@Table(name = "PRICES")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    private int productId;
    private int priority;
    private double price;
    private String curr;
}
