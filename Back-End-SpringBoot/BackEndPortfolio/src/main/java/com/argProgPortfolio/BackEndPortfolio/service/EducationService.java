package com.argProgPortfolio.BackEndPortfolio.service;

import com.argProgPortfolio.BackEndPortfolio.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.argProgPortfolio.BackEndPortfolio.model.Education;
import java.util.List;

@Service
public class EducationService implements IEducationService{
    
    @Autowired
    public EducationRepository educationRepo;

    @Override
    public List<Education> GetJobExperiences() {
        return educationRepo.findAll();
    }
    
    @Override
    public Education GetJobExperienceByID(long id) {
        return educationRepo.findById(id).orElse(null);
    }

    @Override
    public void CreateJobExperience(Education education) {
        
        educationRepo.save(education);
    }
   
    @Override
    public void DeleteJobExperience(Long id) {
        educationRepo.deleteById(id);
    }
    
    @Override
    public List<Education> GetJobExperiencesByPersonaId(Long personaId) {
        return educationRepo.findAllByPersonaId(personaId);
    }
}
