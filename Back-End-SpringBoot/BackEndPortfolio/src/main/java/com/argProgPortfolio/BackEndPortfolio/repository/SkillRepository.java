package com.argProgPortfolio.BackEndPortfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.argProgPortfolio.BackEndPortfolio.model.Skill;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository <Skill, Long> {
    List<Skill> findAllByPersonaId(Long personaId);
}
