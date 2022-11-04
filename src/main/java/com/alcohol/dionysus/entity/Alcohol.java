package com.alcohol.dionysus.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "`alcohol`")
public class Alcohol {
    @Id
    private long id;
    private String chName;
    private Double abv;
}
