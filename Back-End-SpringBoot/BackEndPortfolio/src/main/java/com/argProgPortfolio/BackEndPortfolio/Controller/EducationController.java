package com.argProgPortfolio.BackEndPortfolio.Controller;

import com.argProgPortfolio.BackEndPortfolio.model.Education;
import com.argProgPortfolio.BackEndPortfolio.service.IEducationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducationController {
    
    @Autowired
    private IEducationService educationService;
    
    @GetMapping("/education/{id}")
    public Education GetEducation(@PathVariable long id){
        return educationService.GetEducationByID(id);
    }
    
    @PostMapping("/education/new")
    public void CreateEducation(@RequestBody Education education){
        educationService.CreateEducation(education);
    }
    
    @DeleteMapping("/education/delete/{id}")
    public void DeleteEducation(@PathVariable Long id){
        educationService.DeleteEducation(id);
    }
    
    
    @GetMapping("/educations/{id}")
    public List<Education> GetEducationByPersonaId(@PathVariable long id){
        return educationService.GetEducationByPersonaId(id);
    }
}
