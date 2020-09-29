package com.spring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is Mandatory")
    private String name;

    @NotEmpty(message = "Image is mandatory")
    private String image;

    @NotNull(message = "price is mandatory")
    private Double mainPrice;

    private Double discountPrice;

    private String discountNote;

    @NotEmpty(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Stock is mandatory")
    private int stock;
}
