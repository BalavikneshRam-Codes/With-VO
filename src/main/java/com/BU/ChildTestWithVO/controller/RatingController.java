package com.BU.ChildTestWithVO.controller;

import com.BU.ChildTestWithVO.model.Rating;
import com.BU.ChildTestWithVO.service.RatingService;
import com.BU.ChildTestWithVO.wrapper.RatingRequest;
import com.BU.ChildTestWithVO.wrapper.RatingWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RatingController {
    @Autowired
    private RatingService ratingService;
    Logger logger = LoggerFactory.getLogger(RatingController.class);
    @PostMapping("/submit")
    public ResponseEntity<String> submitRating(@RequestBody RatingRequest ratingRequest){
        logger.info("got ChildId and each question score and goes to Service Layer");
        ratingService.saveRating(ratingRequest.getChildId(),ratingRequest.getRatings(),logger);
        return ResponseEntity.ok("Rating save successfully");
    }

    @GetMapping("/rating/{childId}")
    public List<RatingWrapper> getRating(@PathVariable int childId){
        return ratingService.getRating(childId);
    }
}
