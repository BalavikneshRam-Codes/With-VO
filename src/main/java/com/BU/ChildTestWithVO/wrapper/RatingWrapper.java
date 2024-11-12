package com.BU.ChildTestWithVO.wrapper;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingWrapper {
    private Integer questionId;
    private Integer score;
}
