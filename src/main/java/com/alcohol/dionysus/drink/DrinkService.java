package com.alcohol.dionysus.drink;

import com.alcohol.dionysus.bean.dto.DrinkDto;
import com.alcohol.dionysus.bean.request.DrinkRequest;
import com.alcohol.dionysus.entity.Drink;
import com.alcohol.dionysus.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DrinkService {
    @Autowired
    DrinkRepository drinkRepository;

    @Autowired
    private ModelMapper mapper;

    public DrinkDto createDrink(DrinkRequest request) {
        Drink drink = toEntity(request);

        Drink savedEntity = drinkRepository.save(drink);

        return getDrink(savedEntity.getId());
    }

    public DrinkDto getDrink(Integer id) {
        Optional<Drink> optionalDrink = drinkRepository.findById(id);

        if (optionalDrink.isPresent()) {
            return toDto(optionalDrink.get());
        } else {
            throw new NotFoundException("drink " + id + " not found");
        }
    }

    private Drink toEntity(DrinkRequest request) {
        return mapper.map(request, Drink.class);
    }

    private DrinkDto toDto(Drink entity) {
        return mapper.map(entity, DrinkDto.class);
    }

}
