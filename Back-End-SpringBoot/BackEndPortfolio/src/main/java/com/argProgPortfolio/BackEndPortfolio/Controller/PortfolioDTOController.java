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
import java.util.Date;
import java.util.List;
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
    
    //CRUD mapping para entidades
    //Mapping Persona
    @PostMapping("/portfolio/persona/new/{id}")
    public String CreatePortfolioPersona (@RequestBody Persona pers){
        persService.CreatePersona(pers);
        return "El usuario se creo correctamente";
    }
    
    @DeleteMapping("/portfolio/personsa/delete/{id}")
    public String DeletePortfolioPersona(@PathVariable Long id){
        persService.DeletePersona(id);
        return "El usuario se elimino correctamente";
    }
    
    @PutMapping("/portfolio/persona/update/{id}")
    public void UpdatePersona(@PathVariable long id,
                              @RequestParam("name") String newName,
                              @RequestParam("lastName") String newLastName,
                              @RequestParam("title") String newTitle,
                              @RequestParam("persona_photo") String newPersonaPhoto,
                              @RequestParam("banner_photo") String newBannerPhoto,
                              @RequestParam("phone_number") String newPhoneNumber,
                              @RequestParam("email") String newEmail,
                              @RequestParam("about_me") String newAboutMe) {
        
        Persona pers = persService.GetPersonaById(id);
        
        pers.setName(newName);
        pers.setLastName(newLastName);
        pers.setTitle(newTitle);
        pers.setPersonaPhoto(newPersonaPhoto);
        pers.setBannerPhoto(newBannerPhoto);
        pers.setPhoneNumber(newPhoneNumber);
        pers.setEmail(newEmail);
        pers.setAboutMe(newAboutMe);
        
        persService.UpdatePersona(pers, id);
    }
    
    //Mapping JobExperience
    
    @PostMapping("/portfolio/job/new/{id}")
    public String CreatePortfolioJobExperience (@RequestBody JobExperience job){
        jobService.CreateJobExperience(job);
        return "La experienca laboral se creo correctamente";
    }
    
    @DeleteMapping("/portfolio/job/delete/{id}")
    public String DeleteJobExperience(@PathVariable Long id){
        jobService.DeleteJobExperience(id);
        return "La experienca Laboral fue eliminada correctamente";
    }
    
    @PutMapping("/portfolio/job/update/{id}")
    public JobExperience UpdateJobExperience (@PathVariable long id,
                              @RequestParam("company_name") String newCompanyName,
                              @RequestParam("job_title") String newTitle,
                              @RequestParam("job_start_date") Date newStartDate,
                              @RequestParam("job_end_date") Date newEndDate,
                              @RequestParam("job_photo") String newJobPhoto,
                              @RequestParam("is_current_job") int newCurrentJob,
                              @RequestParam("job_type_id") int newJobType) {
        
        JobExperience jobExperience = jobService.GetJobExperienceByID(id);
        
        jobExperience.setCompanyName(newCompanyName);
        jobExperience.setJobTitle(newTitle);
        jobExperience.setJobStartDate(newStartDate);
        jobExperience.setJobEndDate(newEndDate);
        jobExperience.setJobPhoto(newJobPhoto);
        jobExperience.setIsCurrentJob(newCurrentJob);
        jobExperience.setJobTypeId(newJobType);
        
        jobService.UpdateJobExperience(jobExperience, id);
        return jobExperience;
    }
    
    //Mapping Education
    
    @PostMapping("/portfolio/education/new/{id}")
    @ResponseBody
    public String CreatePortfolioEducation (@RequestBody Education education){
        educationService.CreateEducation(education);
        
        return "La educacion se creo correctamente";
    }
    
    @DeleteMapping("/portfolio/education/delete/{id}")
    public String DeleteEducation(@PathVariable Long id){
        educationService.DeleteEducation(id);
        
        return "La educacion se elimino correctamente";
    }
    
    @PutMapping("/portfolio/education/update/{id}")
    public void UpdateEducation (@PathVariable long id,
                              @RequestParam("education_title") String newEducationTitle,
                              @RequestParam("school_name") String newSchoolName,
                              @RequestParam("education_start_date") Date newStartDate,
                              @RequestParam("education_end_date") Date newEndDate,
                              @RequestParam("school_photo") String newSchoolPhoto) {
        
        Education education = educationService.GetEducationByID(id);
        
        education.setEducationTitle(newEducationTitle);
        education.setSchoolName(newSchoolName);
        education.setEducationStartDate(newStartDate);
        education.setEducationEndDate(newEndDate);
        education.setSchoolPhoto(newSchoolPhoto);

        
        educationService.UpdateEducation(education, id);
    }
    
    //Mapping Proyect
    
    @PostMapping("/portfolio/proyect/new/{id}")
    @ResponseBody
    public String CreatePortfolioProyect (@RequestBody Proyect proyect){
        proyectService.CreateProyect(proyect);
        
        return "El proyecto se creo correctamente";
    }
    
    @DeleteMapping("/portfolio/proyect/delete/{id}")
    public String DeleteProyect(@PathVariable Long id){
        proyectService.DeleteProyect(id);
        
        return "El proyecto se elimino correctamente";
    }
    
    @PutMapping("/portfolio/proyect/update/{id}")
    public void UpdateProyect (@PathVariable long id,
                              @RequestParam("proyect_title") String newProyectTitle,
                              @RequestParam("proyect_description") String newProyectDescription,
                              @RequestParam("proyect_start_date") Date newStartDate,
                              @RequestParam("proyect_end_date") Date newEndDate,
                              @RequestParam("proyect_photo") String newProyectPhoto) {
        
        Proyect proyect = proyectService.GetProyectByID(id);
        
        proyect.setProyectTitle(newProyectTitle);
        proyect.setProyectDescription(newProyectDescription);
        proyect.setProyectStartDate(newStartDate);
        proyect.setProyectEndDate(newEndDate);
        proyect.setProyectPhoto(newProyectPhoto);

        
        proyectService.UpdateProyect(proyect, id);
    }
    
    //Mapping Skill
    
    @PostMapping("/portfolio/skill/new/{id}")
    @ResponseBody
    public String CreatePortfolioSkill (@RequestBody Skill skill){
        skillService.CreateSkill(skill);
        
        return "El skill se creo correctamente";
    }
    
    @DeleteMapping("/portfolio/skill/delete/{id}")
    public String DeleteSkill(@PathVariable Long id){
        skillService.DeleteSkill(id);
        
        return "El skill se elimino correctamente";
    }
    
    @PutMapping("/portfolio/skill/update/{id}")
    public void UpdateSkill (@PathVariable long id,
                              @RequestParam("skill_title") String newSkillTitle,
                              @RequestParam("skill_tipe") String newSkillType,
                              @RequestParam("skill_level") String newSkillLevel,
                              @RequestParam("skill_description") String newSkillDescription) {
        
        Skill skill = skillService.GetSkillByID(id);
        
        skill.setSkillTitle(newSkillTitle);
        skill.setSkillTipe(newSkillType);
        skill.setSkillLevel(newSkillLevel);
        skill.setSkillDescription(newSkillDescription);

        
        skillService.UpdateSkill(skill, id);
    }
}
