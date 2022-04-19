package com.argProgPortfolio.BackEndPortfolio.dto;

import com.argProgPortfolio.BackEndPortfolio.model.Education;
import com.argProgPortfolio.BackEndPortfolio.model.JobExperience;
import com.argProgPortfolio.BackEndPortfolio.model.Proyect;
import com.argProgPortfolio.BackEndPortfolio.model.Skill;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PortfolioDTO implements Serializable{
    
    private long portfolio_id;
    
    private String user;
    
    private String name;
    
    private String lastName;
    
    private String title;
    
    private String personaPhoto;
    
    private String bannerPhoto;
    
    private Date birthDate;
    
    private String phoneNumber;
    
    private String email;
    
    private String aboutMe;
    
    private List<Education> education;
    
    private List<Proyect> proyect;
    
    private List<JobExperience> jobExperience;
    
    private List<Skill> skill;
}
