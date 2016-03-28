package com.levelup.testShop.service.impl;

import com.levelup.testShop.model.Product;
import com.levelup.testShop.repository.ProductRepository;
import com.levelup.testShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by java on 21.03.2016.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        if(product == null){
            throw new IllegalArgumentException("Product can not be null!");
        }
        productRepository.saveProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        if(product == null){
            throw new IllegalArgumentException("Product can not be null!");
        }
        productRepository.updateProduct(product);
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public boolean isExist(long id) {
        return productRepository.isExist(id);
    }
}
