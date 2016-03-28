package com.levelup.testShop.service.impl;

import com.levelup.testShop.model.User;
import com.levelup.testShop.repository.UserRepository;
import com.levelup.testShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by java on 21.03.2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        if(user == null){
            throw new IllegalArgumentException("User can not be null!");
        }
        userRepository.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        if(user == null){
            throw new IllegalArgumentException("User can not be null!");
        }
        userRepository.updateUser(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteUser(id);
    }

    @Override
    public boolean isExist(long id) {
        return userRepository.isExist(id);
    }
}
