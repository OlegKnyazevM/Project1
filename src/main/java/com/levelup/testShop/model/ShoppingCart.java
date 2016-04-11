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
//

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by al on 23.03.2016.
 */
//@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {
    private long id;
    private HashMap<Long, ShoppingCartItem> shoppingCartItemHashMap;
    private BigDecimal totalCartCost;

    public ShoppingCart() {
        shoppingCartItemHashMap = new HashMap<Long, ShoppingCartItem>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ShoppingCartItem addCartItem(Product product, int quantity) {
        ShoppingCartItem currentShoppingCartItem = shoppingCartItemHashMap.get(product.getId());
        if(currentShoppingCartItem != null) {
            currentShoppingCartItem.add(quantity);
        } else {
            currentShoppingCartItem = shoppingCartItemHashMap.put(product.getId(), new ShoppingCartItem(product, quantity));
        }

        return currentShoppingCartItem;
    }

    public ShoppingCartItem addCartItem(Product product){
        return addCartItem(product, 1);
    }

    public int getCartItemQuantity(Product product)  {
        return shoppingCartItemHashMap.get(product.getId()).getQuantity();
    }

    public ShoppingCartItem deleteOrderItem(Product product, int quantity) throws ProductException  {
        ShoppingCartItem currentShoppingCartItem = shoppingCartItemHashMap.get(product.getId());
        if(currentShoppingCartItem != null) {
            currentShoppingCartItem.delete(quantity);
        }

//        add deleting 4 quantity 0 values

        return currentShoppingCartItem;
    }

    private BigDecimal calculateTotalCost() {
        totalCartCost = new BigDecimal(0);
//        for (HashMap<Long, ShoppingCartItem> items: shoppingCartItemHashMap.values())  {
//            totalCartCost = totalCartCost.add(items.getShoppingCartItemPrice());
//        }
        Iterator it = shoppingCartItemHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, ShoppingCartItem> entry = (Map.Entry)it.next();
            totalCartCost = totalCartCost.add(entry.getValue().getShoppingCartItemPrice());
        }
        return totalCartCost;
    }

    public BigDecimal getTotalCartCost() {
        calculateTotalCost();
        return totalCartCost;
    }

    public int getTotalCartItemsQuantity() {
        int quantity = 0;

        Iterator it = shoppingCartItemHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, ShoppingCartItem> entry = (Map.Entry)it.next();
            quantity += entry.getValue().getQuantity();
        }

        return quantity;
    }

    public List<ShoppingCartItem> getShoppingCartItems() {
        List<ShoppingCartItem> shoppingCartItemsList = new ArrayList<ShoppingCartItem>(shoppingCartItemHashMap.values());
        return shoppingCartItemsList;
//        return shoppingCartItemHashMap.entrySet().toArray();
    }
}