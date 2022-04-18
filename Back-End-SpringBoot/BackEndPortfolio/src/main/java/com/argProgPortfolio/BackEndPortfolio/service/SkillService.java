package com.argProgPortfolio.BackEndPortfolio.service;

import com.argProgPortfolio.BackEndPortfolio.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.argProgPortfolio.BackEndPortfolio.model.Skill;
import java.util.List;

@Service
public class SkillService implements ISkillService{
    
    @Autowired
    public SkillRepository skillRepo;

    @Override
    public List<Skill> GetSkills() {
        return skillRepo.findAll();
    }
    
    @Override
    public Skill GetSkillByID(long id) {
        return skillRepo.findById(id).orElse(null);
    }

    @Override
    public void CreateSkill(Skill skill) {
        
        skillRepo.save(skill);
    }
   
    @Override
    public void DeleteSkill(Long id) {
        skillRepo.deleteById(id);
    }
    
    @Override
    public List<Skill> GetSkillsByPersonaId(Long personaId) {
        return skillRepo.findAllByPersonaId(personaId);
    }
}
