package com.korgutlova.services;

import com.korgutlova.model.enums.Subject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Repository
@Transactional
@Qualifier("entity")
public class EntityManagerDao implements ScoresService{

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManagerDao(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public long getTotalScore(long id) {
        return entityManager.createQuery("select sum(s.score) from Score s WHERE s.id_student= :id_student", Long.class)
                .setParameter("id_student", id).getSingleResult();
    }

    @Override
    public double getAverageScore(long id) {
        return entityManager.createQuery("select avg(s.score) from Score s WHERE s.id_student= :id_student", Double.class)
                .setParameter("id_student", id).getSingleResult();
    }

    @Override
    public int getScoreOnTheSubject(long id, Subject subject) {
        return entityManager.createQuery("select s.score from Score s WHERE s.id_student= :id_student " +
                "and s.subject= :subject", Integer.class)
                .setParameter("id_student", id).setParameter("subject", subject).getSingleResult();
    }
}
