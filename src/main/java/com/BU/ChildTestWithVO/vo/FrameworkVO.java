package com.BU.ChildTestWithVO.vo;

import com.BU.ChildTestWithVO.model.Question;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FrameworkVO {
    private Integer frameworkId;
    private String frameworkName;
    private List<QuestionVO> questionVOS;
}
