package com.argProgPortfolio.BackEndPortfolio.service;

import com.argProgPortfolio.BackEndPortfolio.model.Education;
import java.util.List;


public interface IEducationService {
    
    public List<Education> GetEducation();
    
    public Education GetEducationByID(long id);
    
    public void CreateEducation(Education education);
    
    public void DeleteEducation(Long id);
    
    public List<Education> GetEducationByPersonaId(Long personaId);
    
    public void UpdateEducation (Education education, Long id);
}
