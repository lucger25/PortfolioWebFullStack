package com.argProgPortfolio.BackEndPortfolio.service;

import com.argProgPortfolio.BackEndPortfolio.repository.ProyectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.argProgPortfolio.BackEndPortfolio.model.Proyect;
import java.util.List;

@Service
public class ProyectService implements IProyectService{
    
    @Autowired
    public ProyectRepository proyectRepo;

    @Override
    public List<Proyect> GetJobExperiences() {
        return proyectRepo.findAll();
    }
    
    @Override
    public Proyect GetJobExperienceByID(long id) {
        return proyectRepo.findById(id).orElse(null);
    }

    @Override
    public void CreateJobExperience(Proyect proyect) {
        
        proyectRepo.save(proyect);
    }
   
    @Override
    public void DeleteJobExperience(Long id) {
        proyectRepo.deleteById(id);
    }
    
    @Override
    public List<Proyect> GetJobExperiencesByPersonaId(Long personaId) {
        return proyectRepo.findAllByPersonaId(personaId);
    }
}
