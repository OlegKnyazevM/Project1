package com.levelup.testShop.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.math.BigDecimal;

/**
 * Created by java on 21.03.2016.
 */
@JsonAutoDetect
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ProductDto {
    private String title;
    private String description;
//    private BigDecimal price;

    public ProductDto() {
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

//    public BigDecimal getPrice() {
//        return price;
//    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
}
