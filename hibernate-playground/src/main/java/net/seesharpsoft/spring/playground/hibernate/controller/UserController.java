package net.seesharpsoft.spring.playground.hibernate.controller;

import net.seesharpsoft.spring.playground.hibernate.model.User;
import net.seesharpsoft.spring.playground.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public User post(@RequestBody User user) {
        return userService.add(user);
    }
}
