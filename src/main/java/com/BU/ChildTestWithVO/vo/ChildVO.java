package com.BU.ChildTestWithVO.vo;

import com.BU.ChildTestWithVO.model.Framework;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChildVO {
    private Integer childId;
    private String childName;
    private FrameworkVO frameworkVO;
}
