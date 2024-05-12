package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.QuestionDAO;
import com.takima.backskeleton.DAO.QuizzDAO;
import com.takima.backskeleton.models.Question;
import com.takima.backskeleton.models.Quizz;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.Pair;

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

    public Map<String, List<Map<String, Object>>> getQuizTitleQuestionsAndAnswersv2() {
        Map<String, List<Map<String, Object>>> quizAndQuestions = new HashMap<>();
        List<Quizz> quizzes = quizzDAO.findAll();

        for (Quizz quiz : quizzes) {
            int i = 1;
            List<Map<String, Object>> questionStatements = new ArrayList<>();

            for (Long question : quiz.getQuestion_id()) {


                if (question != null) {

                    Question qa = new Question();
                    qa.setQuestion(questionDAO.findById(question).orElseThrow().getQuestion());
                    qa.setReponse(questionDAO.findById(question).orElseThrow().getReponse());
                    qa.setId(questionDAO.findById(question).orElseThrow().getId());
                    qa.setHint(questionDAO.findById(question).orElseThrow().getHint());
                    qa.setChoices(questionDAO.findById(question).orElseThrow().getChoices());

                    Map<String, Object> questionMap = new HashMap<>();

                    questionMap.put("numeroQuestion", String.valueOf(i)); // Numéro de question
                    questionMap.put("questionText", qa.getQuestion());
                    questionMap.put("reponse", qa.getReponse());
                    questionMap.put("choice", qa.getChoices());
                    questionMap.put("id_question", String.valueOf(qa.getId()));
                    questionMap.put("indice", qa.getHint());
                    // Ajouter d'autres clés/valeurs si nécessaire

                    questionStatements.add(questionMap);
                    i ++;
                }
            }

            quizAndQuestions.put(quiz.getTitre(), questionStatements);
        }

        return quizAndQuestions;
    }

    public List<Map<String, Object>> getQuizTitleQuestionsAndAnswersWithId() {
        List<Map<String, Object>> quizAndQuestions = new ArrayList<>();
        List<Quizz> quizzes = quizzDAO.findAll();

        for (Quizz quiz : quizzes) {
            int i = 1;
            List<Map<String, Object>> questionStatements = new ArrayList<>();

            for (Long question : quiz.getQuestion_id()) {
                if (question != null) {
                    Question qa = questionDAO.findById(question).orElseThrow();
                    Map<String, Object> questionMap = new HashMap<>();

                    questionMap.put("id", quiz.getId()); // Ajoute l'ID du quiz
                    questionMap.put("titre", quiz.getTitre()); // Ajoute le titre du quiz
                    questionMap.put("numeroQuestion", String.valueOf(i)); // Numéro de question
                    questionMap.put("questionText", qa.getQuestion());
                    questionMap.put("reponse", qa.getReponse());
                    questionMap.put("choice", qa.getChoices());
                    questionMap.put("indice", qa.getHint());

                    questionStatements.add(questionMap);
                    i++;
                }
            }

            quizAndQuestions.addAll(questionStatements);
        }

        return quizAndQuestions;
    }


}