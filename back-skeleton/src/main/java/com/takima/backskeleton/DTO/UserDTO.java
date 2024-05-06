package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Users;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.util.List;

@Getter
@Setter
@Component

public class UserDTO  {
    private Long id;
    private String nom;
    private String roles;
    private String prenom;
    private String email;
    private int score;
    // Vous n'incluez pas le mot de passe dans ce DTO

    // Constructeur par défaut
    public UserDTO() {}

    // Constructeur prenant toutes les propriétés de l'utilisateur
    public UserDTO(Long id, String nom, String roles, String prenom, String email, int score) {
        this.id = id;
        this.nom = nom;
        this.roles = roles;
        this.prenom = prenom;
        this.email = email;
        this.score = score;
    }





}
