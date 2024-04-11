package com.takima.backskeleton.DAO;


import com.takima.backskeleton.models.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizzDAO extends JpaRepository<Quizz, Long> {

}
