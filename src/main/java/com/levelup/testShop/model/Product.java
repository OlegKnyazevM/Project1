package com.levelup.testShop.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by java on 21.03.2016.
 */
@Entity
@Table(name = "product_table")
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product {
    private long id;
    private String title;
    private String description;
    private BigDecimal price;

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id", unique = true)
    public long getId() {
        return id;
    }

    @Column(name = "product_title", nullable = false)
    public String getTitle() {
        return title;
    }

    @Column(name = "product_description")
    public String getDescription() {
        return description;
    }

    @Column(name = "product_price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

