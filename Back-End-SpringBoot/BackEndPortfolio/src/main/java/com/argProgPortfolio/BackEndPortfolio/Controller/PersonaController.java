package com.argProgPortfolio.BackEndPortfolio.Controller;

import com.argProgPortfolio.BackEndPortfolio.model.JobExperience;
import com.argProgPortfolio.BackEndPortfolio.model.Persona;
import com.argProgPortfolio.BackEndPortfolio.service.IJobExperienceService;
import com.argProgPortfolio.BackEndPortfolio.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    
    @Autowired
    private IPersonaService persService;
    
    @GetMapping("/persona/{id}")
    public Persona GetPortfolio(@PathVariable long id){
        return persService.GetPersonaById(id);
    }
    
    @PostMapping("/persona/new")
    public void CreatePersona(@RequestBody Persona pers){
        persService.CreatePersona(pers);
    }
    
    @DeleteMapping("/personsa/delete/{id}")
    public void DeletePersona(@PathVariable Long id){
        persService.DeletePersona(id);
    }
    
    @PutMapping("/persona/update/{id}")
    public void UpdatePersona(@PathVariable long id,
                              @RequestParam("name") String newName){
        Persona pers = persService.GetPersonaById(id);
        persService.UpdatePersona(pers, id);
    }
}
