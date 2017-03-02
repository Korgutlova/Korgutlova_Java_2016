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

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
