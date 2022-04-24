package com.argProgPortfolio.BackEndPortfolio.security.controller;

import com.argProgPortfolio.BackEndPortfolio.security.model.AppUser;
import com.argProgPortfolio.BackEndPortfolio.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @PostMapping("/login/create/user")
    public String CreateNewUser (@RequestBody AppUser user){
        userService.saveUser(user);
        return "El usuario se Creo correctamente";
    }
    
    @GetMapping("/login/user/{userName}")
    @ResponseBody
    public AppUser GetUserByUserName (@PathVariable String userName){
        return userService.getUserByUserName(userName);
    }
    
    @GetMapping("/login/user/test/{id}")
    @ResponseBody
    public AppUser GetUserById (@PathVariable long id){
        return userService.getUserById(id);
    }
}
