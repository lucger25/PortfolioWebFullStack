package com.argProgPortfolio.BackEndPortfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.argProgPortfolio.BackEndPortfolio.model.Proyect;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectRepository extends JpaRepository <Proyect, Long> {
    List<Proyect> findAllByPersonaId(Long personaId);
}
