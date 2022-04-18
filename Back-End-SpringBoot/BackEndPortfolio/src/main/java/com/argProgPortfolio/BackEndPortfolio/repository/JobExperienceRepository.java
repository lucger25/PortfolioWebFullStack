package com.argProgPortfolio.BackEndPortfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.argProgPortfolio.BackEndPortfolio.model.JobExperience;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface JobExperienceRepository extends JpaRepository <JobExperience, Long> {
    List<JobExperience> findAllByPersonaId(Long personaId);
}
