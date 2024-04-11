package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.QuestionDAO;
import com.takima.backskeleton.DAO.QuizzDAO;
import com.takima.backskeleton.models.Question;
import com.takima.backskeleton.models.Quizz;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Service
public class QuizzService {
    private final QuizzDAO quizzDAO;
    private final QuestionDAO questionDAO;



    public List<Quizz> findAll()
    {
        return quizzDAO.findAll();
    }
    public Map<String, List<String>> getQuizTitleAndQuestions() {
        Map<String, List<String>> quizAndQuestions = new HashMap<>();

        List<Quizz> quizzes = quizzDAO.findAll();

        for (Quizz quiz : quizzes) {
            List<String> questionStatements = new ArrayList<>();
            for (int i = 1; i <= 10; i++) { // Assuming you have maximum 10 questions per quiz
                Long questionId = getQuestionIdForQuiz(quiz, i);
                if (questionId != null) {
                    questionStatements.add(questionDAO.getById(questionId).getQuestion());
                }
            }
            quizAndQuestions.put(quiz.getTitre(), questionStatements);
        }

        return quizAndQuestions;
    }

    private Long getQuestionIdForQuiz(Quizz quiz, int questionNumber) {
        switch (questionNumber) {
            case 1:
                return quiz.getQ1();
            case 2:
                return quiz.getQ1();
            case 3:
                return quiz.getQ3();
            case 4:
                return quiz.getQ4();
            case 5:
                return quiz.getQ5();
            case 6:
                return quiz.getQ6();
            case 7:
                return quiz.getQ7();
            case 8:
                return quiz.getQ8();
            case 9:
                return quiz.getQ9();
            case 10:
                return quiz.getQ10();
            default:
                return null;
        }
    }


}
