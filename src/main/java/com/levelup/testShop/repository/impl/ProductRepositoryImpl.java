package com.levelup.testShop.repository.impl;

import com.levelup.testShop.model.Product;
import com.levelup.testShop.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by java on 21.03.2016.
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveProduct(Product product) {

//        if(product == null){
//            throw new IllegalArgumentException("Product can not be null!");
//        }
        entityManager.persist(product);
    }

    @Override
    public void updateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product can not be null!");
        }
        entityManager.merge(product);
    }

    @Override
    public Product findById(long id) {
        return entityManager.find(Product.class, id);
    }


    @Override
    public List<Product> getAllProduct() {
        Query query = entityManager.createQuery("FROM Product");
        return (List<Product>) query.getResultList();
    }

    @Override
    public void deleteProduct(long id) {
        entityManager.remove(entityManager.find(Product.class, id));
    }

    @Override
    public boolean isExist(long id) {
        return entityManager.find(Product.class, id) != null;
    }

    @Override
    public List<Product> sortByName() {
        Query query=entityManager.createQuery("FROM Product ORDER BY product_title");
        return ( List<Product>) query.getResultList();

    }

    @Override
    public List<Product> sortByPrice() {
        Query query=entityManager.createQuery("FROM Product ORDER BY product_price");
        return ( List<Product>) query.getResultList();
    }
}

