package com.alcohol.dionysus.bean.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DrinkRequest {
    @NotNull
    private Integer alcoholId;
    @NotNull
    private Double volumeMl;
}
