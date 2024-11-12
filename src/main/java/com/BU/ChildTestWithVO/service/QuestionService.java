package com.BU.ChildTestWithVO.service;

import com.BU.ChildTestWithVO.business.QuestionBusiness;
import com.BU.ChildTestWithVO.model.Question;
import com.BU.ChildTestWithVO.repository.QuestionRepository;
import com.BU.ChildTestWithVO.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService{

    @Autowired
    private QuestionBusiness questionBusiness;

    public QuestionVO saveQuestion(QuestionVO question){
        return questionBusiness.save(question);
    }

    public QuestionVO findById(Integer questionId) {
        return questionBusiness.findById(questionId);
    }
}
