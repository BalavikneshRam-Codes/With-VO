package com.BU.ChildTestWithVO.repository;

import com.BU.ChildTestWithVO.model.Framework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrameworkRepository extends JpaRepository<Framework,Integer> {
}
