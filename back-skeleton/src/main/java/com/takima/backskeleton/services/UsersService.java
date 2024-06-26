package com.takima.backskeleton.services;


import com.takima.backskeleton.DAO.UsersDAO;
import com.takima.backskeleton.DTO.StudentDto;
import com.takima.backskeleton.DTO.StudentMapper;
import com.takima.backskeleton.models.Student;
import com.takima.backskeleton.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.IOException;
import java.util.List;
@Component
@RequiredArgsConstructor
@Service
public class UsersService {


    private final UsersDAO usersDAO;

    public List<Users> findAll()
    {
        return usersDAO.findAll();
    }

    public Users getById(Long id) {
        return usersDAO.findById(id).orElseThrow();
    }
    @Transactional
    public void deleteById(Long id)
    {
        usersDAO.deleteById(id);
    }


    @Transactional
    public void addUsers(Users users) {
        try {
            // Vérification des données de l'utilisateur
            if (users == null) {
                throw new IllegalArgumentException("User object cannot be null");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error with Users image", e);
        }


        usersDAO.save(users);
    }


    @Transactional
    public void scoreModification(Users user, int new_score) {
        if (user == null) {
            throw new IllegalArgumentException("User object cannot be null");
        }
        int nouveauScore = user.getScore() + new_score;
        user.setScore(nouveauScore);
        usersDAO.save(user);
    }
}




