package com.korgutlova.model;

import com.korgutlova.model.enums.Subject;

import javax.persistence.*;

@Entity
@Table(name = "scores")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private Subject subject;

    private int score;

    @Column(name = "id_student")
    private long id_student;

    public long getId() {
        return id;
    }

    public Score() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getIdStudent() {
        return id_student;
    }

    public void setIdStudent(long idStudent) {
        this.id_student = idStudent;
    }
}
