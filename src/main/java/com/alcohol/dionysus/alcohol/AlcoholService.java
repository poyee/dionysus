package com.alcohol.dionysus.alcohol;

import com.alcohol.dionysus.alcohol.repository.AlcoholBrandRepository;
import com.alcohol.dionysus.alcohol.repository.AlcoholTypeRepository;
import com.alcohol.dionysus.alcohol.repository.BrandAlcoholRepository;
import com.alcohol.dionysus.bean.dto.AlcoholBrandDto;
import com.alcohol.dionysus.bean.dto.AlcoholDto;
import com.alcohol.dionysus.bean.dto.AlcoholTypeDto;
import com.alcohol.dionysus.bean.request.AlcoholRequestParam;
import com.alcohol.dionysus.entity.AlcoholBrand;
import com.alcohol.dionysus.entity.AlcoholBrand_;
import com.alcohol.dionysus.entity.AlcoholType;
import com.alcohol.dionysus.entity.AlcoholType_;
import com.alcohol.dionysus.entity.BrandAlcohol;
import com.alcohol.dionysus.entity.BrandAlcohol_;
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
    private BrandAlcoholRepository brandAlcoholRepository;


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
        List<BrandAlcohol> brandAlcohols = brandAlcoholRepository.findAll(toSpecification(requestParam));

        return ModelMapperUtils.mapList(mapper, brandAlcohols, AlcoholDto.class);
    }

    private static Specification<BrandAlcohol> toSpecification(AlcoholRequestParam param) {
        return (root, query, cb) -> {
            Predicate typeEq = cb.equal(root.get(BrandAlcohol_.TYPE).get(AlcoholType_.ID), param.getTypeId());
            Predicate brandEq = cb.equal(root.get(BrandAlcohol_.BRAND).get(AlcoholBrand_.ID), param.getBrandId());

            return cb.and(typeEq, brandEq);
        };
    }
}
