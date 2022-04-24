package com.argProgPortfolio.BackEndPortfolio.security.repository;

import com.argProgPortfolio.BackEndPortfolio.security.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long>{
    
    AppUser findByUserName(String userName);
}
