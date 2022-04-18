package com.argProgPortfolio.BackEndPortfolio.service;

import com.argProgPortfolio.BackEndPortfolio.model.Skill;
import java.util.List;


public interface ISkillService {
    
    public List<Skill> GetSkills();
    
    public Skill GetSkillByID(long id);
    
    public void CreateSkill(Skill skill);
    
    public void DeleteSkill(Long id);
    
    public List<Skill> GetSkillsByPersonaId(Long personaId);
}
