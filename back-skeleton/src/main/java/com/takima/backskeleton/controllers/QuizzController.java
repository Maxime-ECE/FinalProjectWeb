package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DAO.QuizzDAO;
import com.takima.backskeleton.models.Question;
import com.takima.backskeleton.models.Quizz;
import com.takima.backskeleton.services.QuizzService;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RequestMapping("quizz")
@RestController
@RequiredArgsConstructor
public class QuizzController {
    private final QuizzService quizzService;
    @GetMapping("")
    public List<Quizz> getAllQuizz() {
        return quizzService.findAll();
    }
/*
    @GetMapping("/title-and-questions")
    public Map<String, List<String>> getQuizTitleAndQuestions() {
        return quizzService.getQuizTitleAndQuestions();
    }
*/

    @GetMapping("/title-and-questions-ANSWERS")
    public Map<String, List<Map<String, Object>>> getQuizTitleAndQuestionsaNDaNWSERv2() {
        return quizzService.getQuizTitleQuestionsAndAnswersv2();
    }
    @GetMapping("/title-and-questions-ANSWERS-with-id")
    public List<Map<String, Object>> getQuizTitleQuestionsAndAnswersWithId() {
        return quizzService.getQuizTitleQuestionsAndAnswersWithId();
    }
}

