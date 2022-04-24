package com.argProgPortfolio.BackEndPortfolio.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="users")
public class AppUser {
    
    @Id
    @Column(name="user_id")
    private long id;
    
    @Column(name="user", unique = true)
    private String userName;
    
    @Column(name="password")
    private String password;
    
    @Column(name="persona_persona_id")
    private long personaId;
    
    @Column(name="persona_persona_user")
    private String personaUser;

    public AppUser(){
    
}
    
    public AppUser(long id, String userName, String password, long personaId, String personaUser) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.personaId = personaId;
        this.personaUser = personaUser;
    }
}
