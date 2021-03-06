package com.levelup.testShop.controller;

import com.levelup.testShop.model.Product;
import com.levelup.testShop.model.ProductException;
import com.levelup.testShop.model.ShoppingCart;
import com.levelup.testShop.model.ShoppingCartItem;
//import com.levelup.testShop.model.ShoppingCartSecond;
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
//@Controller
//@Scope(value = "session")
//@RequestMapping("/cart")
//public class ShoppingCartController {
//
//
//    @Autowired
//    private HttpSession httpSession;
//    @Autowired
//    private ProductService productService;
//
//
//    @RequestMapping(value = "/{id_prod}", method = RequestMethod.GET, produces = "application/json")
//    @ResponseBody
//    public ResponseEntity<ShoppingCartSecond> addCart(@PathVariable long id_prod, Model model, HttpServletRequest httpServletRequest) {
//        Product productCart = productService.findById(id_prod);
//        ShoppingCartItem item= new ShoppingCartItem();
//        item.setQuantity(2);
//        item.setProduct(productCart);
//
//        httpSession = httpServletRequest.getSession(true);
//        ShoppingCartSecond cart;
//        cart = (ShoppingCartSecond) httpSession.getAttribute("cart");
//
//        if (cart == null) {
//            cart = new ShoppingCartSecond();
//            cart.addItem(item);
//            httpSession.setAttribute("cart", cart);
//        } else {
//            cart.addItem(item);
//            httpSession.setAttribute("cart", cart);
//        }
//        model.addAttribute("totalAmount", cart.getTotalAmount());
//        model.addAttribute("totalCost",  cart.getTotalCost());
//        return new ResponseEntity(model, HttpStatus.OK);
//    }
//}

@Controller // было @Component
@Scope(value = "session")
@RequestMapping("/cart") // то, что добавится к урлу localhost:8080/cart/
public class ShoppingCartController {
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/showCart", method = RequestMethod.GET)
    public String showCart(Model model, HttpServletRequest httpServletRequest) {
        ShoppingCart shoppingCart;
//        shoppingCart = new ShoppingCart();
        httpSession = httpServletRequest.getSession(true);
        shoppingCart = (ShoppingCart) httpSession.getAttribute("cart");
        model.addAttribute("items", shoppingCart.getShoppingCartItems());
        return "showCart";
    }

    @RequestMapping(value = "delete/{id_prod}", method = RequestMethod.POST, produces = "application/json")
    public // ModelAndView
    String deleteProduct(@PathVariable("id_prod") long id, Model model, HttpServletRequest httpServletRequest) {
        Product product = productService.findById(id);
        ShoppingCart shoppingCart;
        httpSession = httpServletRequest.getSession(true);
        shoppingCart =  (ShoppingCart) httpSession.getAttribute("cart");
        shoppingCart.deleteCartItem(product);
        httpSession.setAttribute("cart", shoppingCart);
//        model.addAttribute("totalAmount", shoppingCart.getTotalCartItemsQuantity());
//        model.addAttribute("totalCost",  shoppingCart.getTotalCartCost());
//        return new ModelAndView("showCart");
        return "showCart";
    }

    @RequestMapping(value = "/product/{id_prod}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
//    public ResponseEntity addToCart(@PathVariable("id_prod") long id, Model model, HttpServletRequest httpServletRequest) {
    public ResponseEntity addToCart(@PathVariable long id_prod, Model model, HttpServletRequest httpServletRequest) {
        Product product = productService.findById(id_prod);
        ShoppingCart shoppingCart;
        httpSession = httpServletRequest.getSession(true);
//        shoppingCart = (ShoppingCart) httpServletRequest.getAttribute("cart"); //session! not servletRequest
        shoppingCart = (ShoppingCart) httpSession.getAttribute("cart");
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();

        }
        shoppingCart.addCartItem(product);
//        httpServletRequest.setAttribute("cart", shoppingCart); // is not work :( shoppingCart isn't saved
        httpSession.setAttribute("cart", shoppingCart); // it work property :)

        model.addAttribute("totalAmount", shoppingCart.getTotalCartItemsQuantity());
        model.addAttribute("totalCost", shoppingCart.getTotalCartCost());
        model.addAttribute("productTitle", product.getTitle());
//        model.addAttribute("addQuantity", shoppingCart.)

        return new ResponseEntity(model, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/decr/{id_prod}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity decrFromCart(@PathVariable long id_prod, Model model, HttpServletRequest httpServletRequest) {
        Product product = productService.findById(id_prod);
        ShoppingCart shoppingCart;
        httpSession = httpServletRequest.getSession(true);
//        shoppingCart = (ShoppingCart) httpServletRequest.getAttribute("cart"); //session! not servletRequest
        shoppingCart = (ShoppingCart) httpSession.getAttribute("cart");
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();

        }
        try {
            shoppingCart.deleteOrderItem(product, 1);
        } catch (ProductException e) {
            e.printStackTrace();
        }
//        httpServletRequest.setAttribute("cart", shoppingCart); // is not work :( shoppingCart isn't saved
        httpSession.setAttribute("cart", shoppingCart); // it work property :)

        model.addAttribute("totalAmount", shoppingCart.getTotalCartItemsQuantity());
        model.addAttribute("totalCost", shoppingCart.getTotalCartCost());
        model.addAttribute("productTitle", product.getTitle());
//        model.addAttribute("addQuantity", shoppingCart.)

        return new ResponseEntity(model, HttpStatus.OK);
    }
}
