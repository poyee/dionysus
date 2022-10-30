package com.alcohol.dionysus.alcohol.repository;

import com.alcohol.dionysus.entity.Alcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AlcoholRepository extends JpaRepository<Alcohol, Integer>, JpaSpecificationExecutor<Alcohol> {
}
