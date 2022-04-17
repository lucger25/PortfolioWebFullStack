package com.argProgPortfolio.BackEndPortfolio.service;

import com.argProgPortfolio.BackEndPortfolio.model.Persona;

public interface IPersonaService {
    
    public Persona GetPersonaById(long id);
    
    public void CreatePersona (Persona persona);
    
    public void DeletePersona (Long id);
    
    public void UpdatePersona (Persona persona, Long id);
}
