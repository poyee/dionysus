package com.alcohol.dionysus.alcohol;

import com.alcohol.dionysus.alcohol.repository.AlcoholTypeRepository;
import com.alcohol.dionysus.bean.AlcoholTypeDto;
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
    private ModelMapper mapper;

    public List<AlcoholTypeDto> getTypes() {
        List<AlcoholType> types = typeRepository.findAll();
        return ModelMapperUtils.mapList(mapper, types, AlcoholTypeDto.class);
    }
}
