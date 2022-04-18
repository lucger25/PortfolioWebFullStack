package com.argProgPortfolio.BackEndPortfolio.Controller;

import com.argProgPortfolio.BackEndPortfolio.model.JobExperience;
import com.argProgPortfolio.BackEndPortfolio.model.Persona;
import com.argProgPortfolio.BackEndPortfolio.service.IJobExperienceService;
import com.argProgPortfolio.BackEndPortfolio.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobExperienceController {
    
    @Autowired
    private IJobExperienceService jobExperienceService;
    
    @GetMapping("/job/{id}")
    public JobExperience GetJobExperience(@PathVariable long id){
        return jobExperienceService.GetJobExperienceByID(id);
    }
    
    @PostMapping("/job/new")
    public void CreateJobExperience(@RequestBody JobExperience job){
        jobExperienceService.CreateJobExperience(job);
    }
    
    @DeleteMapping("/job/delete/{id}")
    public void DeleteJobExperience(@PathVariable Long id){
        jobExperienceService.DeleteJobExperience(id);
    }
    
    
    @GetMapping("/jobs/{id}")
    public List<JobExperience> GetJobExperiencesByPersonaId(@PathVariable long id){
        return jobExperienceService.GetJobExperiencesByPersonaId(id);
    }
}
