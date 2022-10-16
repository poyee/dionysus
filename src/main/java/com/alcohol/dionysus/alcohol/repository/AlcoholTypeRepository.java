package com.alcohol.dionysus.alcohol.repository;

import com.alcohol.dionysus.entity.AlcoholType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlcoholTypeRepository extends JpaRepository<AlcoholType, Integer> {
}
