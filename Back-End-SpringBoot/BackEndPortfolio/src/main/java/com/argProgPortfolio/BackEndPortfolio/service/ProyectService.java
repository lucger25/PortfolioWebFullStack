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
    public List<Proyect> GetProyect() {
        return proyectRepo.findAll();
    }
    
    @Override
    public Proyect GetProyectByID(long id) {
        return proyectRepo.findById(id).orElse(null);
    }

    @Override
    public void CreateProyect(Proyect proyect) {
        
        proyectRepo.save(proyect);
    }
   
    @Override
    public void DeleteProyect(Long id) {
        proyectRepo.deleteById(id);
    }
    
    @Override
    public List<Proyect> GetProyectByPersonaId(Long personaId) {
        return proyectRepo.findAllByPersonaId(personaId);
    }
    
    @Override
    public void UpdateProyect (Proyect proyect, Long id){
        proyectRepo.save(proyect);
    }
}
