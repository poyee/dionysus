package com.alcohol.dionysus.drink.mapper;

import com.alcohol.dionysus.entity.Alcohol;
import org.modelmapper.AbstractConverter;

public class AlcoholIdToAlcoholConverter extends AbstractConverter<Integer, Alcohol> {
    @Override
    protected Alcohol convert(Integer source) {
        Alcohol alcohol = new Alcohol();
        alcohol.setId(source);
        return alcohol;
    }
}
