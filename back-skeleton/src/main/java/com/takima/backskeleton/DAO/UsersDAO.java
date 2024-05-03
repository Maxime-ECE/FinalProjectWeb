package com.takima.backskeleton.DAO;


import com.takima.backskeleton.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDAO extends JpaRepository<Users, Long> {

    Users findByEmail(String email);
}
