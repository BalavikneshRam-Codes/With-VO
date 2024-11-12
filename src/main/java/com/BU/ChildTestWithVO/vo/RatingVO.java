package com.BU.ChildTestWithVO.vo;

import com.BU.ChildTestWithVO.model.Child;
import com.BU.ChildTestWithVO.model.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingVO {

    private Integer childId;
    private QuestionVO questionVO;
    private Integer score;
}
