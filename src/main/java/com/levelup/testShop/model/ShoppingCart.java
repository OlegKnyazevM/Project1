package com.levelup.testShop.model;
//
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
//
///**
// * Created by Knyazev Oleg
// * on 10.02.16.
// * 1.0.0
// */
//@Component
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
//public class ShoppingCart {
//    private List<ShoppingCartItem> items;
//    private int totalAmount = 0;
//    private BigDecimal totalCost = BigDecimal.valueOf(0);
//
//    public ShoppingCart() {
//        items =new CopyOnWriteArrayList<ShoppingCartItem>();
//        recalcCostAndAmount();
//    }
//
//    public List<ShoppingCartItem> getItems() {
//        return items;
//    }
//
//    public void setItems(List<ShoppingCartItem> items) {
//        this.items = items;
//    }
//
//    public int getTotalAmount() {
//        return totalAmount;
//    }
//
//    public void setTotalAmount(int totalAmount) {
//        this.totalAmount = totalAmount;
//    }
//
//    public BigDecimal getTotalCost() {
//        return totalCost;
//    }
//
//    public void setTotalCost(BigDecimal totalCost) {
//        this.totalCost = totalCost;
//    }
//
//    public void addCart (ShoppingCartItem item){
//        boolean isExist = false;
//        for(ShoppingCartItem it: items){
//            if(it.getProduct().equals(item.getProduct())){
//                it.setQuantity(it.getQuantity() + item.getQuantity());
//                isExist = true;
//                break;
//            }
//            if(!isExist) {
//                items.add(item);
//            }
//        }
//        recalcCostAndAmount();
//
//    }
//
//
//    public void removeItem(ShoppingCartItem item){
//        items.remove(item);
//        recalcCostAndAmount();
//    }
//
//
//    public void recalcCostAndAmount(){
//        for (ShoppingCartItem item : items) {
//            totalCost = totalCost.add(item.calculateTotalCost());
//            totalCost.setScale(2, BigDecimal.ROUND_CEILING);
//            totalAmount += item.getQuantity();
//        }
//
//    }
//
//}

public class ShoppingCart {
    private HashMap<Product, Integer> shoppingCartEntry;

    public ShoppingCart() {
        shoppingCartEntry = new HashMap<Product, Integer>();
    }

    public int addProduct(Product product, int quantity) {
        Integer currentQuantity = 0;
        if(shoppingCartEntry.containsKey(product)) {
            currentQuantity = shoppingCartEntry.get(product);
        }
        shoppingCartEntry.put(product, currentQuantity + quantity);

        return currentQuantity + quantity;
    }

}