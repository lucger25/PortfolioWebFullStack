package com.argProgPortfolio.BackEndPortfolio.model;

import java.util.Date;
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
@Table(name="education")
public class Education {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    
    @Column(name="user")
    private String user;
    
    @Column(name="education_title")
    private String educationTitle;
    
    @Column(name="school_name")
    private String schoolName;
    
    @Column(name="education_start_date")
    private Date educationStartDate;
    
    @Column(name="education_end_date")
    private Date educationEndDate;
    
    @Column(name="school_photo")
    private String schoolPhoto;
    
    @Column(name="persona_id")
    private long personaId;
    
    @Column(name="persona_user")
    private String personaUser;
    
    
        public Education() {
    }

    public Education(long id, String user, String educationTitle, String schoolName, Date educationStartDate, Date educationEndDate, String schoolPhoto, long personaId, String personaUser) {
        this.id = id;
        this.user = user;
        this.educationTitle = educationTitle;
        this.schoolName = schoolName;
        this.educationStartDate = educationStartDate;
        this.educationEndDate = educationEndDate;
        this.schoolPhoto = schoolPhoto;
        this.personaId = personaId;
        this.personaUser = personaUser;
    }
}
