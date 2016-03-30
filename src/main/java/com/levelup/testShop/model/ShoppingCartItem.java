package com.levelup.testShop.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

/**
 * Created by Knyazev Oleg
 * on 21.03.16.
 * Version 1.0.0
 */
@Component
@Scope("session")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingCartItem {
    private  Product product;
    private int quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal calculateTotalCost() {
        BigDecimal totalCost = this.getProduct().getPrice().multiply(new BigDecimal(this.getQuantity()));
        return totalCost;
    }
}