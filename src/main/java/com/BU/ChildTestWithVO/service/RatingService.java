package com.BU.ChildTestWithVO.service;

import com.BU.ChildTestWithVO.business.ChildBusiness;
import com.BU.ChildTestWithVO.business.QuestionBusiness;
import com.BU.ChildTestWithVO.business.RatingBusiness;
import com.BU.ChildTestWithVO.model.Child;
import com.BU.ChildTestWithVO.model.Question;
import com.BU.ChildTestWithVO.model.Rating;
import com.BU.ChildTestWithVO.repository.ChildRepository;
import com.BU.ChildTestWithVO.repository.QuestionRepository;
import com.BU.ChildTestWithVO.repository.RatingRepository;
import com.BU.ChildTestWithVO.vo.ChildVO;
import com.BU.ChildTestWithVO.vo.QuestionVO;
import com.BU.ChildTestWithVO.vo.RatingVO;
import com.BU.ChildTestWithVO.vo.ScoreVO;
import com.BU.ChildTestWithVO.wrapper.RatingWrapper;
import com.BU.ChildTestWithVO.wrapper.RatingWrapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingService {

    @Autowired
    private ChildBusiness childBusiness;

    @Autowired
    private QuestionBusiness questionBusiness;

    @Autowired
    private RatingBusiness ratingBusiness;

    public void saveRating(Integer childId, List<RatingWrapper> ratingWrappers, Logger logger){
        logger.info("Save Rating method is called and data goes to Business Layer");
         ratingBusiness.saveRating(childId,ratingWrappers);
    }

    public List<RatingWrapper> getRating(int childId) {
        List<RatingVO> ratings = ratingBusiness.findByChild_childId(childId);
        return ratings.stream()
                .map(rating -> new RatingWrapper(
                        rating.getQuestionVO().getQuestionId(),
                        rating.getScore()
                )).collect(Collectors.toList());
    }
}
