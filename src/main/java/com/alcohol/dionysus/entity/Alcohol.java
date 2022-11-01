package com.alcohol.dionysus.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "`alcohol`")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Alcohol {
    @Id
    private long id;
    private String chName;
    private Double abv;
}
