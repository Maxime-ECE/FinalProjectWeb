package com.takima.backskeleton.controllers;


import com.takima.backskeleton.DTO.UserDTO;
import com.takima.backskeleton.models.Users;
import com.takima.backskeleton.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("users")
@RestController
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;


    @GetMapping("")
    public List<UserDTO> getAllUsers() {
        return usersService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUsers(@PathVariable Long id) {
        usersService.deleteById(id);
    }

    @PostMapping("")
    public void addUser(@RequestBody Users users) {
        usersService.addUsers(users);
    }

    @PostMapping("/{id}")
    public void increaseScore(@PathVariable("id") Long userId, @RequestBody Users userToUpdate) {
        // Récupérer l'utilisateur en fonction de l'ID dans votre service
        Users user = usersService.getById(userId);
        if (user == null) {
            // Gérer le cas où l'utilisateur n'est pas trouvé
            // Peut-être renvoyer une réponse d'erreur appropriée
            return;
        }

        // Extraire le score à partir du corps de la requête
        int scoreIncrease = userToUpdate.getScore();

        // Mettre à jour le score de l'utilisateur
        usersService.scoreModification(user, scoreIncrease);
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody Users newUser) {
        // Mettre à jour le mot de passe avec le hash
        newUser.setPassword(newUser.getPassword_mdp());
        // Enregistrer l'utilisateur dans la base de données
        usersService.save(newUser);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Users user) {
        // Récupérer l'utilisateur existant depuis la base de données
        Users existingUser = usersService.findByEmail(user.getEmail());

        // Vérifier si l'utilisateur existe et si le mot de passe correspond
        if (existingUser != null && existingUser.checkPassword(user.getPassword_mdp())) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password!");
        }
    }
}
