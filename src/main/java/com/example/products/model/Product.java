package com.example.products.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private long Id;

    @Column(name="product_name", nullable = false, unique = true, length = 412)
    @NotBlank(message = "Product name cannot be blank")
    private String productName;

    @Column(name="product_type", nullable = false)
    @NotBlank(message = "Product type cannot be blank")
    private String productType;

    @Column(name="price", nullable = false)
//    @NotBlank(message = "Product price cannot be blank")
    private Float productPrice;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }
}
