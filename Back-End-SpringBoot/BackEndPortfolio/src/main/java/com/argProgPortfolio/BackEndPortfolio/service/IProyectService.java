package com.argProgPortfolio.BackEndPortfolio.service;

import com.argProgPortfolio.BackEndPortfolio.model.Proyect;
import java.util.List;


public interface IProyectService {
    
    public List<Proyect> GetProyect();

    public Proyect GetProyectByID(long id);

    public void CreateProyect(Proyect proyect);
   
    public void DeleteProyect(Long id);

    public List<Proyect> GetProyectByPersonaId(Long personaId);

}
