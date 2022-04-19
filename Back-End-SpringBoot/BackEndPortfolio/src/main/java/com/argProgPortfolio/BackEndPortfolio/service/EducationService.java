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
    public List<Education> GetEducation() {
        return educationRepo.findAll();
    }
    
    @Override
    public Education GetEducationByID(long id) {
        return educationRepo.findById(id).orElse(null);
    }

    @Override
    public void CreateEducation(Education education) {
        
        educationRepo.save(education);
    }
   
    @Override
    public void DeleteEducation(Long id) {
        educationRepo.deleteById(id);
    }
    
    @Override
    public List<Education> GetEducationByPersonaId(Long personaId) {
        return educationRepo.findAllByPersonaId(personaId);
    }
    
    @Override
    public void UpdateEducation (Education education, Long id){
        educationRepo.save(education);
    }
}
