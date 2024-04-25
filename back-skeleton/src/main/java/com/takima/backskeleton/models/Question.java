package com.takima.backskeleton.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "questions")
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "reponse", nullable = false)
    private String reponse;

    @Column(name = "choices")
    @Convert(converter = StringListConverter.class)
    private List<String> choices;

    @Column(name = "hint")
    private String hint;


    // Getters and setters
}
