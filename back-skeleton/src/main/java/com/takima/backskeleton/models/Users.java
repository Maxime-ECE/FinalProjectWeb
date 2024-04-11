package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter 
@Setter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ma_sequence")

    private Long id;
    private String nom;
    private String roles;
    private String prenom;
    private String email;
    private String password_mdp;
    private int score;


    public Users score(int score) {
        this.score= score;
        return this;
    }
}
