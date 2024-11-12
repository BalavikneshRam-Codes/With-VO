package com.BU.ChildTestWithVO.business;

import com.BU.ChildTestWithVO.model.Child;
import com.BU.ChildTestWithVO.model.Rating;
import com.BU.ChildTestWithVO.model.Score;
import com.BU.ChildTestWithVO.repository.ChildRepository;
import com.BU.ChildTestWithVO.repository.RatingRepository;
import com.BU.ChildTestWithVO.repository.ScoreRepository;
import com.BU.ChildTestWithVO.vo.ChildVO;
import com.BU.ChildTestWithVO.vo.ScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ScoreBusiness {
    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private ChildRepository childRepository;

    public void updateChildPercentageInDatabase(Integer childId, Double percentageScore) {
        Optional<Child> optionalChild = childRepository.findById(childId);
        if (optionalChild.isPresent()) {
            Child child = optionalChild.get();
            child.setPercentageScore(percentageScore);
            childRepository.save(child);
            Score score = new Score();
            score.setChildId(child.getChildId());
            score.setChildScore(percentageScore);
            scoreRepository.save(score);
        } else {
            throw new IllegalArgumentException("Child with ID " + childId + " not found.");
        }
    }
}
