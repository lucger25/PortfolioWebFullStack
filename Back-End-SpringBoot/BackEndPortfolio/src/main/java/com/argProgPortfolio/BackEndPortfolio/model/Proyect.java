package com.argProgPortfolio.BackEndPortfolio.model;

import java.util.Date;
import javax.persistence.Access;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="proyect")
public class Proyect {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;
    
    @Column(name="user")
    private String user;
    
    @Column(name="proyect_title")
    private String proyectTitle;
    
    @Column(name="proyect_description")
    private String proyectDescription;
    
    @Column(name="proyect_start_date")
    private Date proyectStartDate;
    
    @Column(name="proyect_end_date")
    private Date proyectEndDate;
    
    @Column(name="proyect_photo")
    private String proyectPhoto;
    
    @Column(name="persona_id")
    private long personaId;
    
    @Column(name="persona_user")
    private String personaUser;
    
    
        public Proyect() {
    }

    public Proyect(long id, String user, String proyectTitle, String proyectDescription, Date proyectStartDate, Date proyectEndDate, String proyectPhoto, long personaId, String personaUser) {
        this.id = id;
        this.user = user;
        this.proyectTitle = proyectTitle;
        this.proyectDescription = proyectDescription;
        this.proyectStartDate = proyectStartDate;
        this.proyectEndDate = proyectEndDate;
        this.proyectPhoto = proyectPhoto;
        this.personaId = personaId;
        this.personaUser = personaUser;
    }
        
        

}
