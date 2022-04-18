package com.argProgPortfolio.BackEndPortfolio.service;

import com.argProgPortfolio.BackEndPortfolio.model.Proyect;
import java.util.List;


public interface IProyectService {
    
    public List<Proyect> GetJobExperiences();

    public Proyect GetJobExperienceByID(long id);

    public void CreateJobExperience(Proyect proyect);

   
    public void DeleteJobExperience(Long id);

    public List<Proyect> GetJobExperiencesByPersonaId(Long personaId);

}
