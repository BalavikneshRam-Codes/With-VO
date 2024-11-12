package com.BU.ChildTestWithVO.repository;

import com.BU.ChildTestWithVO.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score,Integer> {
}
