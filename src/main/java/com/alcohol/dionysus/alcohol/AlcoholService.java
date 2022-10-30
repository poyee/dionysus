package com.alcohol.dionysus.alcohol;

import com.alcohol.dionysus.alcohol.repository.AlcoholBrandRepository;
import com.alcohol.dionysus.alcohol.repository.AlcoholTypeRepository;
import com.alcohol.dionysus.bean.dto.AlcoholBrandDto;
import com.alcohol.dionysus.bean.dto.AlcoholTypeDto;
import com.alcohol.dionysus.entity.AlcoholBrand;
import com.alcohol.dionysus.entity.AlcoholType;
import com.alcohol.dionysus.utils.ModelMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlcoholService {
    @Autowired
    private AlcoholTypeRepository typeRepository;

    @Autowired
    private AlcoholBrandRepository brandRepository;


    @Autowired
    private ModelMapper mapper;

    public List<AlcoholTypeDto> getTypes() {
        List<AlcoholType> types = typeRepository.findAll();
        return ModelMapperUtils.mapList(mapper, types, AlcoholTypeDto.class);
    }

    public List<AlcoholBrandDto> getBrands(Integer typeId) {
        List<AlcoholBrand> brands = brandRepository.findAllByAlcoholTypes_Id(typeId);
        return ModelMapperUtils.mapList(mapper, brands, AlcoholBrandDto.class);
    }
}
