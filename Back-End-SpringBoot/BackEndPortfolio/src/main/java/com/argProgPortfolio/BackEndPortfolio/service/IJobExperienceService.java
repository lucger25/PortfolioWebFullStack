package com.argProgPortfolio.BackEndPortfolio.service;

import com.argProgPortfolio.BackEndPortfolio.model.JobExperience;
import java.util.List;


public interface IJobExperienceService {
    
    public List<JobExperience> GetJobExperiences();
    
    public JobExperience GetJobExperienceByID(long id);
    
    public void CreateJobExperience(JobExperience jobExperience);
    
    public void DeleteJobExperience(Long id);
    
    public List<JobExperience> GetJobExperiencesByPersonaId(Long personaId);
    
    public void UpdateJobExperience (JobExperience jobExperience, Long id);
}
