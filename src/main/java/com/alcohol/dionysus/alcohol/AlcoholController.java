package com.alcohol.dionysus.alcohol;

import com.alcohol.dionysus.bean.dto.AlcoholBrandDto;
import com.alcohol.dionysus.bean.dto.AlcoholTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("alcohol")
public class AlcoholController {
    @Autowired
    AlcoholService service;

    @GetMapping("types")
    public List<AlcoholTypeDto> getTypes() {
        return service.getTypes();
    }

    @GetMapping("brands")
    public List<AlcoholBrandDto> getBrands(@RequestParam("typeId") Integer typeId) {
        return service.getBrands(typeId);
    }
}
