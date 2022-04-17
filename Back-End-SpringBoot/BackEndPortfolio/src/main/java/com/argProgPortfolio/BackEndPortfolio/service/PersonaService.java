package com.argProgPortfolio.BackEndPortfolio.service;

import com.argProgPortfolio.BackEndPortfolio.model.Persona;
import com.argProgPortfolio.BackEndPortfolio.repository.PersonaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    public PersonaRepository persRepo;
    @Override
    public Persona GetPersonaById(long id) {
     return persRepo.findById(id).orElse(null);
    }

    @Override
    public void CreatePersona(Persona persona) {
        
        persRepo.save(persona);
    }

    @Override
    public void DeletePersona(Long id) {
        persRepo.deleteById(id);
    }
    
    @Override
    public void UpdatePersona(Persona persona, Long id) {
        persRepo.save(persona);
    }
}
