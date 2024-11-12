package com.BU.ChildTestWithVO.business;

import com.BU.ChildTestWithVO.model.Child;
import com.BU.ChildTestWithVO.model.Framework;
import com.BU.ChildTestWithVO.model.Question;
import com.BU.ChildTestWithVO.model.Rating;
import com.BU.ChildTestWithVO.repository.ChildRepository;
import com.BU.ChildTestWithVO.repository.FrameworkRepository;
import com.BU.ChildTestWithVO.service.ChildService;
import com.BU.ChildTestWithVO.vo.ChildVO;
import com.BU.ChildTestWithVO.vo.FrameworkVO;
import com.BU.ChildTestWithVO.vo.QuestionVO;
import com.BU.ChildTestWithVO.vo.RatingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChildBusiness {

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private FrameworkRepository frameworkRepository;


    public ChildVO save(ChildVO childVO) {
        // Null checks at the start
        if (childVO == null || childVO.getFrameworkVO() == null || childVO.getFrameworkVO().getFrameworkId() == null) {
            throw new IllegalArgumentException("Framework ID must be provided");
        }

        // Fetch Framework from the database
        Framework framework = frameworkRepository.findById(childVO.getFrameworkVO().getFrameworkId())
                .orElseThrow(() -> new IllegalArgumentException("Framework not found"));

        // Create and save the Child entity
        Child child = new Child();
        child.setChildName(childVO.getChildName());
        child.setFramework(framework);
        child = childRepository.save(child);

        // Update childVO with the generated childId
        childVO.setChildId(child.getChildId());

        // Map Framework details to FrameworkVO
        FrameworkVO frameworkVO = new FrameworkVO();
        frameworkVO.setFrameworkId(framework.getFrameworkId());
        frameworkVO.setFrameworkName(framework.getFrameworkName());

        // Map Questions to QuestionVO
        List<QuestionVO> questionVOS = (framework.getQuestions() != null ? framework.getQuestions().stream().map(
                question -> {
                    QuestionVO questionVO = new QuestionVO();
                    questionVO.setQuestionTitle(question.getQuestionTitle());
                    questionVO.setQuestionId(question.getQuestionId());
                    return questionVO;
                }
        ).collect(Collectors.toList()) : null);

        frameworkVO.setQuestionVOS(questionVOS);
        childVO.setFrameworkVO(frameworkVO);

        return childVO;
    }


    public List<ChildVO> findAll() {
        List<ChildVO> childVOS = new ArrayList<>();
        List<Child> children = childRepository.findAll();
        children.forEach(child -> {
            ChildVO childVO = new ChildVO();
            childVO.setChildName(child.getChildName());
            childVO.setChildId(child.getChildId());
            childVOS.add(childVO);
        });
        return childVOS;
    }

    public ChildVO findById(Integer childId) {
        Child child = childRepository.findById(childId).get();
        ChildVO childVO = new ChildVO();
        childVO.setChildId(child.getChildId());
        childVO.setChildName(childVO.getChildName());
        Framework framework = child.getFramework();
        FrameworkVO frameworkVO = new FrameworkVO();

        frameworkVO.setFrameworkName(framework.getFrameworkName());
        frameworkVO.setFrameworkId(framework.getFrameworkId());

        List<QuestionVO> questionVOS =  framework.getQuestions().stream()
                .map(question -> {
                    QuestionVO questionVO = new QuestionVO();
                    questionVO.setQuestionId(question.getQuestionId());
                    questionVO.setQuestionTitle(question.getQuestionTitle());
                    return questionVO;
                }).collect(Collectors.toList());
        frameworkVO.setQuestionVOS(questionVOS);
        childVO.setFrameworkVO(frameworkVO);
        return childVO;
    }
}
