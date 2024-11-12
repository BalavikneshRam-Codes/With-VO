package com.BU.ChildTestWithVO.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer childId;
    private String childName;
    private Double percentageScore = 0.0;
    @ManyToOne(cascade = CascadeType.ALL)
    private Framework framework;

}
