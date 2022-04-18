package com.argProgPortfolio.BackEndPortfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.argProgPortfolio.BackEndPortfolio.model.Education;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository <Education, Long> {
    List<Education> findAllByPersonaId(Long personaId);
}
