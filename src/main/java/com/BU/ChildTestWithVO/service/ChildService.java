package com.BU.ChildTestWithVO.service;

import com.BU.ChildTestWithVO.business.ChildBusiness;
import com.BU.ChildTestWithVO.business.FrameworkBusiness;
import com.BU.ChildTestWithVO.model.Child;
import com.BU.ChildTestWithVO.model.Framework;
import com.BU.ChildTestWithVO.repository.ChildRepository;
import com.BU.ChildTestWithVO.repository.FrameworkRepository;
import com.BU.ChildTestWithVO.vo.ChildVO;
import com.BU.ChildTestWithVO.vo.FrameworkVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildService {

    @Autowired
    private FrameworkBusiness frameworkBusiness;

    @Autowired
    private ChildBusiness childBusiness;

    public ChildVO addChild(ChildVO childVO,Logger logger){
        logger.info("Child data goes to business layer");
        return childBusiness.save(childVO);
    }

}
