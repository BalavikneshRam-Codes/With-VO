package com.BU.ChildTestWithVO.business;

import com.BU.ChildTestWithVO.model.Question;
import com.BU.ChildTestWithVO.repository.QuestionRepository;
import com.BU.ChildTestWithVO.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestionBusiness {
    @Autowired
    private QuestionRepository questionRepository;

    public  QuestionVO findById(Integer questionId) {
        Question question = questionRepository.findById(questionId).get();
        QuestionVO questionVO = new QuestionVO();
        questionVO.setQuestionId(question.getQuestionId());
        questionVO.setQuestionTitle(question.getQuestionTitle());
        return questionVO;
    }


    public QuestionVO save(QuestionVO question) {
        Question question1 = new Question();
        question1.setQuestionId(question.getQuestionId());
        question1.setQuestionTitle(question.getQuestionTitle());
        questionRepository.save(question1);
        return question;
    }
}
