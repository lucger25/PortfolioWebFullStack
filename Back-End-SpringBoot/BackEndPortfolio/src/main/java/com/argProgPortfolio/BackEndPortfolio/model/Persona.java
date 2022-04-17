package com.argProgPortfolio.BackEndPortfolio.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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
