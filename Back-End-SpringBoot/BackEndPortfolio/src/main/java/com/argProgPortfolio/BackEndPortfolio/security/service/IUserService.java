package com.argProgPortfolio.BackEndPortfolio.security.service;

import com.argProgPortfolio.BackEndPortfolio.security.model.AppUser;


public interface IUserService {
    
    public AppUser saveUser(AppUser user);
    
    public AppUser getUserByUserName(String userName);
    
    public AppUser getUserById(Long id);
}
