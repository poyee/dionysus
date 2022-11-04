package com.alcohol.dionysus.drink.mapper;

import com.alcohol.dionysus.bean.request.DrinkRequest;
import com.alcohol.dionysus.entity.Drink;
import org.modelmapper.PropertyMap;

public class DrinkRequestToEntityMap extends PropertyMap<DrinkRequest, Drink> {
    @Override
    protected void configure() {
        using(new AlcoholIdToAlcoholConverter()).map(source.getAlcoholId()).setAlcohol(null);
    }
}
