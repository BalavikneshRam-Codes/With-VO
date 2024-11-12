package com.BU.ChildTestWithVO.controller;

import com.BU.ChildTestWithVO.model.Child;
import com.BU.ChildTestWithVO.service.ChildService;
import com.BU.ChildTestWithVO.vo.ChildVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChildController {
    Logger logger = LoggerFactory.getLogger(ChildController.class);
    @Autowired
    ChildService childService;

    @PostMapping("/addChild")
    public ChildVO addChild(@RequestBody ChildVO child){
        try {
            if (child.getFrameworkVO() == null || child.getFrameworkVO().getFrameworkId() == null) {
                throw new IllegalArgumentException("FrameworkVO and FrameworkId must be provided");
            }
            logger.info("Child " + child.getChildName() + " Entered with all details");
        }catch (RuntimeException e)
        {
            logger.info(e.getMessage());
        }
        return childService.addChild(child, logger);
    }
}
