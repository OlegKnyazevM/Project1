package com.levelup.testShop.repository.impl;

import com.levelup.testShop.model.User;
import com.levelup.testShop.repository.UserRepository;
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
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveUser(User user)  {
        if(user == null){
            throw new IllegalArgumentException("User can not be null!");
        }
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        if(user == null){
            throw new IllegalArgumentException("User can not be null!");
        }
        entityManager.merge(user);

    }

    @Override
    public User findById(long id) {
        return entityManager.find(User.class , id);
    }

    @Override
    public List<User> getAllUser()  {
        Query query = entityManager.createQuery("FROM User");
        return (List<User>) query.getResultList();
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(entityManager.find(User.class , id));

    }

    @Override
    public boolean isExist(long id) {
        return entityManager.find(User.class, id) != null;
    }


}

