package com.BU.ChildTestWithVO.service;

import com.BU.ChildTestWithVO.business.FrameworkBusiness;
import com.BU.ChildTestWithVO.model.Framework;
import com.BU.ChildTestWithVO.model.Question;
import com.BU.ChildTestWithVO.repository.FrameworkRepository;
import com.BU.ChildTestWithVO.vo.FrameworkVO;
import com.BU.ChildTestWithVO.vo.QuestionVO;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrameworkService {
    @Autowired
    private FrameworkBusiness frameworkBusiness;
    public FrameworkVO addFramework(FrameworkVO framework,Logger logger){
        logger.info("Framework has been entered to Business Layer");
        return frameworkBusiness.save(framework);
    }
}
