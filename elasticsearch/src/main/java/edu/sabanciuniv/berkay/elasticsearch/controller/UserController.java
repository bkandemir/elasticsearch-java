package edu.sabanciuniv.berkay.elasticsearch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sabanciuniv.berkay.elasticsearch.domain.User;
import edu.sabanciuniv.berkay.elasticsearch.repository.UserRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class UserController
{
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listProducts(Model model)
    {
        List<User> users = new ArrayList<User>();

        Iterable<User> u = userRepository.findAll();
        Iterator uIterator = u.iterator();

        while (uIterator.hasNext())
        {
            users.add((User)uIterator.next());
        }

        model.addAttribute("users", users);
        model.addAttribute("usersCount", users.size());
        model.addAttribute("searchStr", "");

        return "home";
    }

    @RequestMapping(value="/search", method = RequestMethod.POST)
    public String searchAlbums(@RequestParam(value="firstname") String firstname, Model model)
    {

        List<User> users = new ArrayList<User>();

        Iterable<User> u = userRepository.findByFirstNameContaining(firstname);
        Iterator uIterator = u.iterator();

        while (uIterator.hasNext())
        {
            users.add((User)uIterator.next());
        }

        model.addAttribute("users", users);
        model.addAttribute("usersCount", users.size());
        model.addAttribute("searchStr", firstname);

        return "home";
    }

}