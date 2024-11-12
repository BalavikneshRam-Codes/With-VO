package com.BU.ChildTestWithVO.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ratingId;
    private Integer score;

    @ManyToOne(cascade = CascadeType.ALL)
    private Child child;

    @ManyToOne
    private Question question;
}
