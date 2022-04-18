package com.argProgPortfolio.BackEndPortfolio.Controller;

import com.argProgPortfolio.BackEndPortfolio.model.Proyect;
import com.argProgPortfolio.BackEndPortfolio.service.IProyectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProyectController {
    
    @Autowired
    private IProyectService proyectService;
    
    @GetMapping("/proyect/{id}")
    public Proyect GetProyect(@PathVariable long id){
        return proyectService.GetProyectByID(id);
    }
    
    @PostMapping("/proyect/new")
    public void CreateProyect(@RequestBody Proyect proyect){
        proyectService.CreateProyect(proyect);
    }
    
    @DeleteMapping("/proyect/delete/{id}")
    public void DeleteProyect(@PathVariable Long id){
        proyectService.DeleteProyect(id);
    }
    
    
    @GetMapping("/proyects/{id}")
    public List<Proyect> GetProyectByPersonaId(@PathVariable long id){
        return proyectService.GetProyectByPersonaId(id);
    }
}
