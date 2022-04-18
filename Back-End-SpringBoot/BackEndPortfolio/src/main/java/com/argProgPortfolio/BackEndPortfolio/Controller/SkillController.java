package com.argProgPortfolio.BackEndPortfolio.Controller;

import com.argProgPortfolio.BackEndPortfolio.model.Skill;
import com.argProgPortfolio.BackEndPortfolio.service.ISkillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController {
    
    @Autowired
    private ISkillService skillService;
    
    @GetMapping("/skill/{id}")
    public Skill GetSkill(@PathVariable long id){
        return skillService.GetSkillByID(id);
    }
    
    @PostMapping("/skill/new")
    public void CreateSkill(@RequestBody Skill skill){
        skillService.CreateSkill(skill);
    }
    
    @DeleteMapping("/skill/delete/{id}")
    public void DeleteSkill(@PathVariable Long id){
        skillService.DeleteSkill(id);
    }
    
    
    @GetMapping("/skills/{id}")
    public List<Skill> GetSkillByPersonaId(@PathVariable long id){
        return skillService.GetSkillsByPersonaId(id);
    }
}
