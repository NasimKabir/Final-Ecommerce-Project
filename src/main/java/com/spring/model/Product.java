package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String productCode;

    @NotEmpty(message = "Name is Mandatory")
    private String name;

    @NotEmpty(message = "Image is mandatory")
    private String image;

    @NotNull(message = "price is mandatory")
    private BigDecimal mainPrice;

    private BigDecimal discountPrice;

    private String discountNote;

    @NotEmpty(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Stock is mandatory")
    private int stock;
}
