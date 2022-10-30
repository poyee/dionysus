package com.alcohol.dionysus.bean.dto;

import lombok.Data;

@Data
public class AlcoholDto {
    private Integer id;
    private String chName;
    private String enName;
    private String rawType;
    private Double abv;
}
