package com.BU.ChildTestWithVO.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreVO {
    public Integer childId;
    public Double childScore;
}
