package com.levelup.testShop.controller;

import com.levelup.testShop.model.Product;
import com.levelup.testShop.model.ShoppingCartItem;
import com.levelup.testShop.model.ShoppingCartSecond;
import com.levelup.testShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by java on 30.03.2016.
 */
@Controller
@Scope(value = "session")
@RequestMapping("/cart")
public class ShoppingCartController {


    @Autowired
    private HttpSession httpSession;
    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/{id_prod}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<ShoppingCartSecond> addCart(@PathVariable long id_prod, Model model, HttpServletRequest httpServletRequest) {
        Product productCart = productService.findById(id_prod);
        ShoppingCartItem item= new ShoppingCartItem();
        item.setQuantity(2);
        item.setProduct(productCart);

        httpSession = httpServletRequest.getSession(true);
        ShoppingCartSecond cart;
        cart = (ShoppingCartSecond) httpSession.getAttribute("cart");

        if (cart == null) {
            cart = new ShoppingCartSecond();
            cart.addItem(item);
            httpSession.setAttribute("cart", cart);
        } else {
            cart.addItem(item);
            httpSession.setAttribute("cart", cart);
        }
        model.addAttribute("totalAmount", cart.getTotalAmount());
        model.addAttribute("totalCost",  cart.getTotalCost());
        return new ResponseEntity(model, HttpStatus.OK);
    }
}
