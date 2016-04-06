package com.levelup.testShop.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by java on 06.04.2016.
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartSecond {
    private List<ShoppingCartItem> shoppingCartItem;
    private BigDecimal totalCost = BigDecimal.valueOf(0);
    private Integer totalAmount = 0;

    public ShoppingCartSecond() {
        shoppingCartItem = new CopyOnWriteArrayList<ShoppingCartItem>();
    }

    public List<ShoppingCartItem> getShoppingCartItem() {
        return shoppingCartItem;
    }

    public void setShoppingCartItem(List<ShoppingCartItem> shoppingCartItem) {
        this.shoppingCartItem = shoppingCartItem;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void addItem(ShoppingCartItem item){
        boolean isExist = false;
        for(ShoppingCartItem it: shoppingCartItem){
            if(it.getProduct().getTitle().equals(item.getProduct().getTitle())){
                it.setQuantity(it.getQuantity() + item.getQuantity());
                isExist = true;
                break;
            }
        }
        if(!isExist){
            shoppingCartItem.add(item);
        }
        recalcTotalCostAndAmount();
    }

    public void removeItem(ShoppingCartItem item){
        shoppingCartItem.remove(item);
        recalcTotalCostAndAmount();
    }

    public void recalcTotalCostAndAmount(){
        totalAmount  = 0;
        totalCost = new BigDecimal(0);
        for (ShoppingCartItem item : shoppingCartItem) {
            totalCost = totalCost.add(item.calculateTotalCost());
            totalCost.setScale(2, BigDecimal.ROUND_CEILING);
            totalAmount += item.getQuantity();
        }
    }



}
