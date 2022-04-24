package com.argProgPortfolio.BackEndPortfolio.security.service;

import com.argProgPortfolio.BackEndPortfolio.security.model.AppUser;
import com.argProgPortfolio.BackEndPortfolio.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        return userRepository.save(user);
    }

    @Override
    public AppUser getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
    
    
    @Override
    public AppUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
