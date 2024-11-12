package com.BU.ChildTestWithVO.controller;

import com.BU.ChildTestWithVO.model.Framework;
import com.BU.ChildTestWithVO.service.FrameworkService;
import com.BU.ChildTestWithVO.vo.FrameworkVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrameworkController {
    @Autowired
    private FrameworkService frameworkService;
    Logger logger = LoggerFactory.getLogger(FrameworkController.class);
    @PostMapping("/addFramework")
    public FrameworkVO addFramework(@RequestBody FrameworkVO framework){
        try {
            if (framework.getFrameworkName() != null && framework.getQuestionVOS().isEmpty()) {
                logger.info("Framework name or questionList is empty or null");
                throw new RuntimeException("Framework name and questionList is null or empty");
            }
            logger.info("Framework has been entered : Framework Name is " + framework.getFrameworkName());
        }catch (RuntimeException e){
            logger.info(e.getMessage());
        }
        return frameworkService.addFramework(framework,logger);
    }
}
