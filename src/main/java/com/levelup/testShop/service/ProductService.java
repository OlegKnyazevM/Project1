package com.levelup.testShop.service;

import com.levelup.testShop.model.Product;

import java.util.List;

/**
 * Created by java on 21.03.2016.
 */
public interface ProductService {
        public void saveProduct(Product product);
        public void updateProduct(Product product);
        public Product findById(long id) ;
        public List<Product> getAllProduct();
        public void deleteProduct(long id);
        public boolean isExist(long id);

}
