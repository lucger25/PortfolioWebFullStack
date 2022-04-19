package com.argProgPortfolio.BackEndPortfolio.Controller;

import com.argProgPortfolio.BackEndPortfolio.model.JobExperience;
import com.argProgPortfolio.BackEndPortfolio.model.Persona;
import com.argProgPortfolio.BackEndPortfolio.model.Skill;
import com.argProgPortfolio.BackEndPortfolio.model.Education;
import com.argProgPortfolio.BackEndPortfolio.model.Proyect;
import com.argProgPortfolio.BackEndPortfolio.dto.PortfolioDTO;
import com.argProgPortfolio.BackEndPortfolio.service.IEducationService;
import com.argProgPortfolio.BackEndPortfolio.service.IJobExperienceService;
import com.argProgPortfolio.BackEndPortfolio.service.IPersonaService;
import com.argProgPortfolio.BackEndPortfolio.service.IProyectService;
import com.argProgPortfolio.BackEndPortfolio.service.ISkillService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioDTOController {
    
    @Autowired
    private IPersonaService persService;
    
    @Autowired
    private IJobExperienceService jobService;
    
    @Autowired
    private IEducationService educationService;
    
    @Autowired
    private IProyectService proyectService;
    
    @Autowired
    private ISkillService skillService;
    
    @GetMapping("/portfolio/{id}")
    @ResponseBody
    public PortfolioDTO GetPortfolioByPersonaId(@PathVariable long id){
        
        Persona persona = persService.GetPersonaById(id);
        List<Education> education = educationService.GetEducationByPersonaId(id);
        List<Proyect> proyect = proyectService.GetProyectByPersonaId(id);
        List<JobExperience> jobExperience = jobService.GetJobExperiencesByPersonaId(id);
        List<Skill> skill = skillService.GetSkillsByPersonaId(id);
        
        
        PortfolioDTO portfolio = new PortfolioDTO();
        
        portfolio.setPortfolio_id(persona.getId());
        portfolio.setUser(persona.getUser());
        portfolio.setName(persona.getName());
        portfolio.setLastName(persona.getLastName());
        portfolio.setTitle(persona.getTitle());
        portfolio.setPersonaPhoto(persona.getPersonaPhoto());
        portfolio.setBannerPhoto(persona.getBannerPhoto());
        portfolio.setBirthDate(persona.getBirthDate());
        portfolio.setPhoneNumber(persona.getPhoneNumber());
        portfolio.setEmail(persona.getEmail());
        portfolio.setAboutMe(persona.getAboutMe());
        portfolio.setEducation(education);
        portfolio.setProyect(proyect);
        portfolio.setJobExperience(jobExperience);
        portfolio.setSkill(skill);
        
        return portfolio;
    }
    
}
