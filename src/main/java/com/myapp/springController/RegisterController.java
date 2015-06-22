package com.myapp.springController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.domain.User;
import com.myapp.service.UserService;

@RestController
@RequestMapping("/user")
public class RegisterController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    public User getUser(@PathVariable("userName") String userName) {
      System.out.println("getUser");
        return userService.getUser(userName);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void register(@RequestBody User user) {
     // System.out.println("register");
         userService.addUser(user);
    }
}
