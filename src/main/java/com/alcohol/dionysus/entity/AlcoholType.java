package com.alcohol.dionysus.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "`alcohol_type`")
public class AlcoholType {
    @Id
    private Integer id;
    private String chName;
    private String enName;
}
