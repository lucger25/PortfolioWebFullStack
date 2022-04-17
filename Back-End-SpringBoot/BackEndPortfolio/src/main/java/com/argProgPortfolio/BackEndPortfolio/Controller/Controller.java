package com.argProgPortfolio.BackEndPortfolio.Controller;

import com.argProgPortfolio.BackEndPortfolio.model.Persona;
import com.argProgPortfolio.BackEndPortfolio.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @Autowired
    private IPersonaService persService;
    
    @GetMapping("/datos/{id}")
    public Persona GetPortfolio(@PathVariable long id){
        return persService.GetPersonaById(id);
    }
    
    @PostMapping("/new/datos")
    public void CreatePersona(@RequestBody Persona pers){
        persService.CreatePersona(pers);
    }
    
    @DeleteMapping("/delete/datos/{id}")
    public void DeletePersona(@PathVariable Long id){
        persService.DeletePersona(id);
    }
    
    @PutMapping("/update/datos/{id}")
    public void UpdatePersona(@RequestBody Persona pers, @PathVariable long id){
        persService.UpdatePersona(pers, id);
    }
    
}
