package com.BU.ChildTestWithVO.repository;

import com.BU.ChildTestWithVO.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RatingRepository extends JpaRepository<Rating,Integer> {
    List<Rating> findByChild_childId(int childId);
}
