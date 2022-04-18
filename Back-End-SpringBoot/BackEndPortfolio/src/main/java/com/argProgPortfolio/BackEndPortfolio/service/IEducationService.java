package com.argProgPortfolio.BackEndPortfolio.service;

import com.argProgPortfolio.BackEndPortfolio.model.Education;
import java.util.List;


public interface IEducationService {
    
    public List<Education> GetJobExperiences();
    
    public Education GetJobExperienceByID(long id);
    
    public void CreateJobExperience(Education education);
    
    public void DeleteJobExperience(Long id);
    
    public List<Education> GetJobExperiencesByPersonaId(Long personaId);
}
