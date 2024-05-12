package com.takima.backskeleton.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "quizz")
@Getter
@Setter
public class Quizz {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ma_sequence")
    long id;
    private String titre;
    @Convert(converter = IntListConverter.class)
    private List<Long> question_id;
    @Lob
    @Column
    private byte[] image;
}