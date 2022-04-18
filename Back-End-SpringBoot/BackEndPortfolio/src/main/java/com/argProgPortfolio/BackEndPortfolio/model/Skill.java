package com.argProgPortfolio.BackEndPortfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="skill")
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    
    @Column(name="user")
    private String user;
     
    @Column(name="skill_title")
    private String skillTitle;
    
    @Column(name="skill_tipe")
    private String skillTipe;
    
    @Column(name="skill_level")
    private String skillLevel;
    
    @Column(name="skill_description")
    private String skillDescription;
    
    @Column(name="persona_id")
    private long personaId;
    
    @Column(name="persona_user")
    private String personaUser;
    
    
        public Skill() {
    }

    public Skill(long id, String user, String skillTitle, String skillTipe, String skillLevel, String skillDescription, long personaId, String personaUser) {
        this.id = id;
        this.user = user;
        this.skillTitle = skillTitle;
        this.skillTipe = skillTipe;
        this.skillLevel = skillLevel;
        this.skillDescription = skillDescription;
        this.personaId = personaId;
        this.personaUser = personaUser;
    }

        
}
