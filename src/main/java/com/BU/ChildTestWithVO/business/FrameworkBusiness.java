package com.BU.ChildTestWithVO.business;

import com.BU.ChildTestWithVO.model.Child;
import com.BU.ChildTestWithVO.model.Framework;
import com.BU.ChildTestWithVO.model.Question;
import com.BU.ChildTestWithVO.repository.FrameworkRepository;
import com.BU.ChildTestWithVO.vo.ChildVO;
import com.BU.ChildTestWithVO.vo.FrameworkVO;
import com.BU.ChildTestWithVO.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class FrameworkBusiness {
    @Autowired
    private FrameworkRepository frameworkRepository;

    public FrameworkVO findById(int id){
        Framework framework = frameworkRepository.findById(id).get();
        FrameworkVO frameworkVO = new FrameworkVO();
        frameworkVO.setFrameworkId(framework.getFrameworkId());
        frameworkVO.setFrameworkName(framework.getFrameworkName());
        return frameworkVO;
    }
    public FrameworkVO save(FrameworkVO frameworkVO){
        Framework framework = new Framework();
        framework.setFrameworkName(frameworkVO.getFrameworkName());
        List<Question> questions = frameworkVO.getQuestionVOS().stream()
                .map(vo->{
                    Question question = new Question();
                    question.setQuestionTitle(vo.getQuestionTitle());
                    question.setFramework(framework);
                    return question;
                }).collect(Collectors.toList());
        framework.setQuestions(questions);
        frameworkRepository.save(framework);
        frameworkVO.setFrameworkId(framework.getFrameworkId());
        frameworkVO.setQuestionVOS(questions.stream()
                .map(question -> new QuestionVO(question.getQuestionId(), question.getQuestionTitle())).collect(Collectors.toList()));
        return frameworkVO;

    }
}

