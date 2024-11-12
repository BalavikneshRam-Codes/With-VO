package com.BU.ChildTestWithVO.service;


import com.BU.ChildTestWithVO.business.ChildBusiness;
import com.BU.ChildTestWithVO.business.RatingBusiness;
import com.BU.ChildTestWithVO.business.ScoreBusiness;
import com.BU.ChildTestWithVO.model.Child;
import com.BU.ChildTestWithVO.model.Rating;
import com.BU.ChildTestWithVO.model.Score;
import com.BU.ChildTestWithVO.repository.ChildRepository;
import com.BU.ChildTestWithVO.repository.RatingRepository;
import com.BU.ChildTestWithVO.repository.ScoreRepository;
import com.BU.ChildTestWithVO.vo.ChildVO;
import com.BU.ChildTestWithVO.vo.RatingVO;
import com.BU.ChildTestWithVO.vo.ScoreVO;
import com.BU.ChildTestWithVO.wrapper.RatingWrapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ScoreService {
    @Autowired
    private ScoreBusiness scoreBusiness;

    @Autowired
    private ChildBusiness childBusiness;
    @Autowired
    private RatingBusiness ratingBusiness;

    public List<ScoreVO> getAllscore(Logger logger) {
        List<RatingVO> ratingVOS = ratingBusiness.findAll();
        List<ChildVO> childVOS = childBusiness.findAll();
        Map<Integer, Double> totalScores = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (RatingVO ratingVO : ratingVOS) {
            Integer childId = ratingVO.getChildId();
            Integer score = ratingVO.getScore();

            totalScores.put(childId, totalScores.getOrDefault(childId, 0.0) + score);
            countMap.put(childId, countMap.getOrDefault(childId, 0) + 1);
        }
        List<ScoreVO> scoreVOS = new ArrayList<>();
        for (ChildVO child : childVOS) {
            Integer childId = child.getChildId();
            Double totalScore = totalScores.getOrDefault(childId, 0.0);
            int count = countMap.getOrDefault(childId, 0);

            Double averageScore = count > 0 ? totalScore / count : 0.0;

            Double percentageScore = (averageScore / 4) * 100;

           scoreBusiness.updateChildPercentageInDatabase(childId, percentageScore);
           ScoreVO scoreVO = new ScoreVO();
           scoreVO.setChildId(childId);
           scoreVO.setChildScore(percentageScore);
           scoreVOS.add(scoreVO);
        }
        return scoreVOS;
    }

}
