package com.argProgPortfolio.BackEndPortfolio.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="job_experience")
public class JobExperience {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    
    @Column(name="user")
    private String user;
    
    @Column(name="company_name")
    private String companyName;
    
    @Column(name="job_title")
    private String jobTitle;
    
    @Column(name="job_start_date")
    private Date jobStartDate;
    
    @Column(name="job_end_date")
    private Date jobEndDate;
    
    @Column(name="job_photo")
    private String jobPhoto;
    
    @Column(name="is_current_job")
    private int isCurrentJob;
    
    @Column(name="persona_id")
    private long personaId;
    
    @Column(name="persona_user")
    private String personaUser;
    
    @Column(name="job_type_id")
    private int jobTypeId;
    
    
        public JobExperience() {
    }

    public JobExperience(long id, String user, String companyName, String jobTitle, Date jobStartDate, Date jobEndDate, String jobPhoto, int isCurrentJob, long personaId, String personaUser, int jobTypeId) {
        this.id = id;
        this.user = user;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.jobStartDate = jobStartDate;
        this.jobEndDate = jobEndDate;
        this.jobPhoto = jobPhoto;
        this.isCurrentJob = isCurrentJob;
        this.personaId = personaId;
        this.personaUser = personaUser;
        this.jobTypeId = jobTypeId;
    }

        
}
