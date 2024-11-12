package com.BU.ChildTestWithVO.vo;

import com.BU.ChildTestWithVO.model.Framework;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionVO {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;
    private String questionTitle;

}
