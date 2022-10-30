package com.alcohol.dionysus.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "`brand_alcohol`")
public class Alcohol {
    @Id
    private Integer id;
    private String chName;
    private String enName;
    private String rawType;
    private Double abv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="alcohol_type_id")
    private AlcoholType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="alcohol_brand_id")
    private AlcoholBrand brand;
}
