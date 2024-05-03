package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.Users;
import com.takima.backskeleton.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("users")
@RestController
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;

    @GetMapping("")
    public List<Users> getAllUsers() {
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
}
