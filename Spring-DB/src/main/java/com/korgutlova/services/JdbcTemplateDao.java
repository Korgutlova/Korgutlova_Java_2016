package com.korgutlova.services;

import com.korgutlova.model.enums.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class JdbcTemplateDao implements ScoresService {

    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long getTotalScore(long id) {
        return jdbcTemplate.queryForObject("select sum(score) from scores WHERE id_student=?", Long.class, id);
    }

    @Override
    public double getAverageScore(long id) {
        return jdbcTemplate.queryForObject("select avg(score) from scores WHERE id_student=?", Double.class, id);
    }

    @Override
    public int getScoreOnTheSubject(long id, Subject subject) {
        return jdbcTemplate.queryForObject("select score from scores WHERE id_student=? and subject=?",
                Integer.class, id, subject.toString());
    }
}
