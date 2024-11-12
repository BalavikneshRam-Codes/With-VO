package com.BU.ChildTestWithVO.controller;

import com.BU.ChildTestWithVO.model.Score;
import com.BU.ChildTestWithVO.service.ScoreService;
import com.BU.ChildTestWithVO.vo.ScoreVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ScoreController {
    @Autowired
    ScoreService scoreService;
    Logger logger = LoggerFactory.getLogger(ScoreController.class);
    @GetMapping("/allscore")
    public List<ScoreVO> getAllscore(){
        logger.info("ALl score request has been called and goes to Service Layer");
         return scoreService.getAllscore(logger);
    }
}
