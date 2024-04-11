package com.takima.backskeleton.services;
import com.takima.backskeleton.DAO.QuestionDAO;

import com.takima.backskeleton.models.Question;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionDAO questionDAO;

    public List<Question> findAll()
    {
        return questionDAO.findAll();
    }



    public Question getById(Long id) {
        return questionDAO.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id)
    {
        questionDAO.deleteById(id);
    }

    @Transactional
    public void addQuestion(Question question) {
        try {

            if (question == null) {
                throw new IllegalArgumentException("question object cannot be null");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error with question image", e);
        }


        questionDAO.save(question);
    }


}
