package com.korgutlova.services;

import com.korgutlova.model.enums.Subject;

public interface ScoresService {
    long getTotalScore(long id);

    double getAverageScore(long id);

    int getScoreOnTheSubject(long id, Subject subject);
}
