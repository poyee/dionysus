package com.alcohol.dionysus.bean.dto;

import lombok.Data;

@Data
public class DrinkDto {
    private Integer id;
    private Double volumeMl;
    private AlcoholDto alcohol;
}
