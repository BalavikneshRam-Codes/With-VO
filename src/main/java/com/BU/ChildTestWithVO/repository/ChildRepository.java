package com.BU.ChildTestWithVO.repository;

import com.BU.ChildTestWithVO.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepository extends JpaRepository<Child,Integer> {
}
