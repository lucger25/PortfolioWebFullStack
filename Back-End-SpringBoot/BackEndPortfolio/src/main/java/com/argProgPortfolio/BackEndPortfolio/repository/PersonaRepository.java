package com.argProgPortfolio.BackEndPortfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.argProgPortfolio.BackEndPortfolio.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long>{
    
}
