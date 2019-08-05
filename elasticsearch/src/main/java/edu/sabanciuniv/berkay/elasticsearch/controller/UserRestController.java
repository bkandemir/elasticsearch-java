package edu.sabanciuniv.berkay.elasticsearch.controller;


import edu.sabanciuniv.berkay.elasticsearch.domain.User;
import edu.sabanciuniv.berkay.elasticsearch.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class UserRestController
{
    private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/rest/allusers")
    public List<User> users()
    {
        List<User> users = new ArrayList<User>();

        Iterable<User> user = userRepository.findAll();
        Iterator uIterator = user.iterator();

        while (uIterator.hasNext())
        {
            users.add((User)uIterator.next());
        }

        return users;
    }

    @RequestMapping("/rest/allusers/full")
    public Iterable<User> usersInFull()
    {
        Iterable<User> user = userRepository.findAll();
        Iterator uIterator = user.iterator();

        return user;
    }
}