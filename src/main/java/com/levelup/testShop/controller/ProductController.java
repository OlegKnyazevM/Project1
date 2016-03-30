package com.levelup.testShop.controller;

import com.levelup.testShop.dto.ProductDto;
import com.levelup.testShop.model.Product;
import com.levelup.testShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by java on 21.03.2016.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity saveProduct(@RequestBody ProductDto productDto){
//        Product product = new Product();
//        if (product != null){
//            return new ResponseEntity(HttpStatus.CONFLICT);
//        }
//        product.setTitle(productDto.getTitle());
//        product.setDescription(productDto.getDescription());
//        product.setPrice(productDto.getPrice());
//        productService.saveProduct(product);
//        return new ResponseEntity(product , HttpStatus.OK);
//    }
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showProdForm(){
        return "add_prod";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute ProductDto productDto){
        Product product = new Product();
//        if (product != null){
//            return "Product exist";
//        }
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
//        product.setPrice(productDto.getPrice());
        productService.saveProduct(product);
        return "greeting";
    }

    @RequestMapping(value = "/getAll" , method = RequestMethod.GET)
     public String getAllProducts(Model model){
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        return "all_prod";
    }

    @RequestMapping(value = "findById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteProduct(@PathVariable Long id){
        if(id == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        productService.deleteProduct(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
