package com.alcohol.dionysus.alcohol;

import com.alcohol.dionysus.alcohol.repository.AlcoholBrandRepository;
import com.alcohol.dionysus.alcohol.repository.AlcoholRepository;
import com.alcohol.dionysus.alcohol.repository.AlcoholTypeRepository;
import com.alcohol.dionysus.bean.dto.AlcoholBrandDto;
import com.alcohol.dionysus.bean.dto.AlcoholDto;
import com.alcohol.dionysus.bean.dto.AlcoholTypeDto;
import com.alcohol.dionysus.bean.param.AlcoholRequestParam;
import com.alcohol.dionysus.entity.Alcohol;
import com.alcohol.dionysus.entity.AlcoholBrand;
import com.alcohol.dionysus.entity.AlcoholBrand_;
import com.alcohol.dionysus.entity.AlcoholType;
import com.alcohol.dionysus.entity.AlcoholType_;
import com.alcohol.dionysus.entity.Alcohol_;
import com.alcohol.dionysus.utils.ModelMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;

@Service
public class AlcoholService {
    @Autowired
    private AlcoholTypeRepository typeRepository;

    @Autowired
    private AlcoholBrandRepository brandRepository;

    @Autowired
    private AlcoholRepository alcoholRepository;


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

    public List<AlcoholDto> getAlcohols(AlcoholRequestParam requestParam) {
        List<Alcohol> alcohols = alcoholRepository.findAll(toSpecification(requestParam));

        return ModelMapperUtils.mapList(mapper, alcohols, AlcoholDto.class);
    }

    private static Specification<Alcohol> toSpecification(AlcoholRequestParam param) {
        return (root, query, cb) -> {
            Predicate typeEq = cb.equal(root.get(Alcohol_.TYPE).get(AlcoholType_.ID), param.getTypeId());
            Predicate brandEq = cb.equal(root.get(Alcohol_.BRAND).get(AlcoholBrand_.ID), param.getBrandId());

            return cb.and(typeEq, brandEq);
        };
    }
}
