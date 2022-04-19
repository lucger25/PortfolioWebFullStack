package com.argProgPortfolio.BackEndPortfolio.service;

import com.argProgPortfolio.BackEndPortfolio.repository.JobExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.argProgPortfolio.BackEndPortfolio.model.JobExperience;
import java.util.List;

@Service
public class JobExperienceService implements IJobExperienceService{
    
    @Autowired
    public JobExperienceRepository jobExperienceRepo;

    @Override
    public List<JobExperience> GetJobExperiences() {
        return jobExperienceRepo.findAll();
    }
    
    @Override
    public JobExperience GetJobExperienceByID(long id) {
        return jobExperienceRepo.findById(id).orElse(null);
    }

    @Override
    public void CreateJobExperience(JobExperience jobExperience) {
        
        jobExperienceRepo.save(jobExperience);
    }
   
    @Override
    public void DeleteJobExperience(Long id) {
        jobExperienceRepo.deleteById(id);
    }
    
    @Override
    public List<JobExperience> GetJobExperiencesByPersonaId(Long personaId) {
        return jobExperienceRepo.findAllByPersonaId(personaId);
    }
    
    @Override
    public void UpdateJobExperience (JobExperience jobExperience, Long id){
        jobExperienceRepo.save(jobExperience);
    }
}
