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
    private long q1;
    private long q2;
    private long q3;
    private long q4;
    private long q5;
    private long q6;
    private long q7;
    private long q8;
    private long q9;
    private long q10;
    @Lob
    @Column
    private byte[] image;
}
