package com.BU.ChildTestWithVO.business;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
@Component
public class RatingBusiness {
    @Autowired
    private ChildBusiness childBusiness;
    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ChildRepository childRepository;

    public List<RatingVO> findAll() {
        List<Rating> ratings = ratingRepository.findAll();
        return ratings.stream().map(
                rating -> {
                    RatingVO ratingVO = new RatingVO();
                    ratingVO.setChildId(rating.getChild().getChildId());
                    ratingVO.setScore(rating.getScore());

                    QuestionVO questionVO = new QuestionVO();
                    questionVO.setQuestionTitle(rating.getQuestion().getQuestionTitle());
                    questionVO.setQuestionId(rating.getQuestion().getQuestionId());
                    ratingVO.setQuestionVO(questionVO);
                    return ratingVO;
                }
        ).collect(Collectors.toList());
    }


    public List<RatingVO> findByChild_childId(int childId) {
        System.out.println("Fetching ratings for childId: " + childId);
        List<RatingVO> ratingVO = new ArrayList<>();
        List<Rating> ratings =  ratingRepository.findByChild_childId(childId);
        System.out.println("Found " + ratings.size() + " ratings.");

        ratings.forEach(rating -> {
            RatingVO ratingVO1 = new RatingVO();
            QuestionVO questionVO = new QuestionVO();
            questionVO.setQuestionId(rating.getQuestion().getQuestionId());
            questionVO.setQuestionTitle(rating.getQuestion().getQuestionTitle());
            ratingVO1.setQuestionVO(questionVO);
            ratingVO1.setScore(rating.getScore());
            ratingVO.add(ratingVO1);
        });
        return ratingVO;
    }

    public void saveRating(Integer childId, List<RatingWrapper> ratingWrappers) {
        Child child = childRepository.findById(childId).orElseThrow(()->new NoSuchElementException(""));
        List<Rating> rating = ratingWrappers.stream()
                .map(ratingWrapper -> {
                    Question question = questionRepository.findById(ratingWrapper.getQuestionId()).get();
                    Rating rating1 = new Rating();
                    rating1.setScore(ratingWrapper.getScore());
                    rating1.setChild(child);
                    rating1.setQuestion(question);
                    return rating1;
                }).collect(Collectors.toList());
        ratingRepository.saveAll(rating);
    }


}
