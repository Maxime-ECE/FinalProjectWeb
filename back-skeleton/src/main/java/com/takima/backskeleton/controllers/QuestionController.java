package com.takima.backskeleton.controllers;
import com.takima.backskeleton.models.Question;
import com.takima.backskeleton.models.Users;
import com.takima.backskeleton.services.QuestionService;
import com.takima.backskeleton.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("question")
@RestController
@RequiredArgsConstructor

public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("")
    public List<Question> getAllQuestion() {
        return questionService.findAll();
    }
    @GetMapping("/{id}")
    public Question getQuestionbyId(@PathVariable Long id) {
        return questionService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteById(id);
    }

    @PostMapping("")
    public void addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
    }

}
