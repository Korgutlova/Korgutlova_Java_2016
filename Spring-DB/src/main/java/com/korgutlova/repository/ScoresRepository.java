package com.korgutlova.repository;

import com.korgutlova.model.Score;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface ScoresRepository extends CrudRepository<Score, Long>{
}