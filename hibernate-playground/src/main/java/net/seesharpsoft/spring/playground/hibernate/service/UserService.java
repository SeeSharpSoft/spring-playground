package net.seesharpsoft.spring.playground.hibernate.service;

import net.seesharpsoft.spring.playground.hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private User.Repository repository;


    public Collection<User> getAll() {
        return repository.findAll();
    }

    public User add(User user) {
        return repository.saveAndFlush(user);
    }
}
