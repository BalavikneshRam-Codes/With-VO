package com.BU.ChildTestWithVO.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingRequest {
    private Integer childId;
    private List<RatingWrapper> ratings;
}
