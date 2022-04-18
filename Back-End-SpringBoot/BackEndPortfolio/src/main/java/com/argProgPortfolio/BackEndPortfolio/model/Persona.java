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
@Table(name="persona")
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="persona_id")
    private long id;
    
    @Column(name="persona_user")
    private String user;
    
    @Column(name="name")
    private String name;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="title")
    private String title;
    
    @Column(name="persona_photo")
    private String personaPhoto;
    
    @Column(name="banner_photo")
    private String bannerPhoto;
    
    @Column(name="birth_date")
    private Date birthDate;
    
    @Column(name="phone_number")
    private String phoneNumber;
    
    @Column(name="email")
    private String email;
    
    @Column(name="about_me")
    private String aboutMe;
    
    public Persona() {
    }

    public Persona(int id, String user, String name, String lastName, String title, String personaPhoto, Date birthDate, String phoneNumber, String email, String aboutMe) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.lastName = lastName;
        this.title = title;
        this.personaPhoto = personaPhoto;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.aboutMe = aboutMe;
    }
}
