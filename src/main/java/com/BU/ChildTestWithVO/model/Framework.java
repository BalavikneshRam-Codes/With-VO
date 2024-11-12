package com.BU.ChildTestWithVO.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Framework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer frameworkId;
    private String frameworkName;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "framework")
    @JsonManagedReference
    private List<Question> questions;
}
