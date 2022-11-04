package com.alcohol.dionysus.bean.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AlcoholRequestParam {
    @NotNull
    Integer typeId;
    @NotNull
    Integer brandId;
}
