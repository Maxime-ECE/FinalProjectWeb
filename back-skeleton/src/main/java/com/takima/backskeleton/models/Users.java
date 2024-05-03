package com.takima.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    public void setPassword(String password) {
        // Créez un encodeur BCrypt
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Encodez le mot de passe avec BCrypt
        String hashedPassword = passwordEncoder.encode(password);

        // Stockez le mot de passe chiffré dans la base de données
        this.password_mdp = hashedPassword;
    }

    // Ajoutez éventuellement une méthode pour vérifier si le mot de passe correspond
    public boolean checkPassword(String password) {
        // Créez un encodeur BCrypt
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Vérifiez si le mot de passe correspond au mot de passe chiffré stocké
        return passwordEncoder.matches(password, this.password_mdp);
    }

    public Users score(int score) {
        this.score= score;
        return this;
    }
}
