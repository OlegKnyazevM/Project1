package com.levelup.testShop.service;

import com.levelup.testShop.model.User;

import java.util.List;

/**
 * Created by java on 21.03.2016.
 */
public interface UserService {
        public void saveUser(User user);
        public void updateUser(User user);
        public User findById(long id) ;
        public List<User> getAllUser();
        public void deleteUser(long id);
        public boolean isExist(long id);

}
