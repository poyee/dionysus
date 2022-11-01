package com.alcohol.dionysus.alcohol.repository;

import com.alcohol.dionysus.entity.BrandAlcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandAlcoholRepository extends JpaRepository<BrandAlcohol, Integer>, JpaSpecificationExecutor<BrandAlcohol> {
}
