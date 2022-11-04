package com.alcohol.dionysus.drink;

import com.alcohol.dionysus.bean.dto.DrinkDto;
import com.alcohol.dionysus.bean.request.DrinkRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("drinks")
public class DrinkController {
    @Autowired
    DrinkService service;

    @PostMapping("")
    public DrinkDto createDrink(@RequestBody @Valid DrinkRequest request) {
        return service.createDrink(request);
    }

    @GetMapping("{id}")
    public DrinkDto createDrink(@PathVariable(name = "id") Integer id) {
        return service.getDrink(id);
    }
}
