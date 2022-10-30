package com.alcohol.dionysus.alcohol.repository;

import com.alcohol.dionysus.entity.AlcoholBrand;
import com.alcohol.dionysus.entity.AlcoholType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface AlcoholBrandRepository extends JpaRepository<AlcoholBrand, Integer> {
    List<AlcoholBrand> findAllByAlcoholTypes_Id(Integer typeId);
}
