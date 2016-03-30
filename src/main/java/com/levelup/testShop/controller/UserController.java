package com.levelup.testShop.controller;

import com.levelup.testShop.dto.UserDto;
import com.levelup.testShop.model.User;
import com.levelup.testShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by java on 21.03.2016.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/add" , method = RequestMethod.POST , headers = { "Content-type=application/json;charset=UTF-8"
//    })
//    @ResponseBody
//    public ResponseEntity saveUser(@RequestBody UserDto userDto){
//        User user = new User();
//        user.setEmail(userDto.getEmail());
//        user.setPass(userDto.getPass());
//        userService.saveUser(user);
//        return new ResponseEntity(user, HttpStatus.OK);
//    }
@RequestMapping(value = "/add", method = RequestMethod.GET)
public String showProdForm(){
    return "add_user";
}

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute UserDto userDto){
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPass(userDto.getPass());
        userService.saveUser(user);
        return "greeting";
    }

    @RequestMapping(value = "/getAll" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAllUsers(){
        List<User> users = userService.getAllUser();

        return new ResponseEntity(users , HttpStatus.OK);
    }

    @RequestMapping(value = "/findById/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity findById(@PathVariable Long id){
        User user = userService.findById(id);
        return new ResponseEntity( user , HttpStatus.OK);

    }

    @RequestMapping(value = "/deleteUser/{id}" , method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteUser(@PathVariable ("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
