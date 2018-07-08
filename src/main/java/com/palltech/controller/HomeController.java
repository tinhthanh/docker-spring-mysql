/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.palltech.controller;
import com.palltech.model.User;
import com.palltech.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

/**
 *
 * @author Trinh
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    UserService userService;
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap model){
        Optional<User>  user =   this.userService.getUserByUserName("thanh");
        model.addAttribute("message", "Spring MVC XML Config Example"  + user.get().getUsername());
        return "index";
    }
}
