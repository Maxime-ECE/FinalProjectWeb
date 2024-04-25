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
    public Map<String, List<String>> getQuizTitleAndQuestions() {
        Map<String, List<String>> quizAndQuestions = new HashMap<>();
        List<Quizz> quizzes = quizzDAO.findAll();
        for (Quizz quiz : quizzes) {
            List<String> questionStatements = new ArrayList<>();

            for (int i = 1; i <= 10; i++)
            {
                Long questionId = getQuestionIdForQuiz(quiz, i);
                if (questionId != null)
                {
                    questionStatements.add(questionDAO.findById(questionId).orElseThrow().getQuestion());
                }
            }
            quizAndQuestions.put(quiz.getTitre(), questionStatements);
        }
        return quizAndQuestions;
    }



    public Map<String, List<Map<String, Object>>> getQuizTitleQuestionsAndAnswersv2() {
        Map<String, List<Map<String, Object>>> quizAndQuestions = new HashMap<>();
        List<Quizz> quizzes = quizzDAO.findAll();

        for (Quizz quiz : quizzes) {
            List<Map<String, Object>> questionStatements = new ArrayList<>();

            for (int i = 1; i <= 10; i++) {
                Long questionId = getQuestionIdForQuiz(quiz, i);
                if (questionId != null) {
                    Question qa = new Question();
                    qa.setQuestion(questionDAO.findById(questionId).orElseThrow().getQuestion());
                    qa.setReponse(questionDAO.findById(questionId).orElseThrow().getReponse());
                    qa.setId(questionDAO.findById(questionId).orElseThrow().getId());
                    qa.setHint(questionDAO.findById(questionId).orElseThrow().getHint());
                    qa.setChoices(questionDAO.findById(questionId).orElseThrow().getChoices());

                    Map<String, Object> questionMap = new HashMap<>();

                    questionMap.put("numeroQuestion", String.valueOf(i)); // Numéro de question
                    questionMap.put("questionText", qa.getQuestion());
                    questionMap.put("reponse", qa.getReponse());
                    questionMap.put("choice", qa.getChoices());
                    questionMap.put("id_question", String.valueOf(qa.getId()));
                    questionMap.put("indice", qa.getHint());
                    // Ajouter d'autres clés/valeurs si nécessaire

                    questionStatements.add(questionMap);
                }
            }

            quizAndQuestions.put(quiz.getTitre(), questionStatements);
        }

        return quizAndQuestions;
    }


    public Map<Integer, Map<String, String>> getQuizTitleQuestionsAndAnswers() {
        Map<Integer, Map<String, String>> quizAndQuestions = new HashMap<>();
        List<Quizz> quizzes = quizzDAO.findAll();
        for (Quizz quiz : quizzes) {
            for (int i = 1; i <= 10; i++) {
                Long questionId = getQuestionIdForQuiz(quiz, i);
                if (questionId != null) {
                    Question question = questionDAO.findById(questionId).orElseThrow();
                    Map<String, String> questionAndAnswer = new HashMap<>();
                    questionAndAnswer.put("a", questionDAO.findById(questionId).orElseThrow().getQuestion());
                    questionAndAnswer.put("b", questionDAO.findById(questionId).orElseThrow().getReponse());
                    quizAndQuestions.put(i, questionAndAnswer);
                }
            }
        }

        return quizAndQuestions;
    }

    private Long getQuestionIdForQuiz(Quizz quiz, int questionNumber) {
        switch (questionNumber) {
            case 1:
                return quiz.getQ1();
            case 2:
                return quiz.getQ2();
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
