package com.alcohol.dionysus.entity;

import com.alcohol.dionysus.bean.dto.AlcoholTypeDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "`alcohol_brand`")
public class AlcoholBrand {
    @Id
    private Integer id;
    private String chName;
    private String enName;

    @ManyToMany
    @JoinTable(name = "alcohol_type_brand", joinColumns = { @JoinColumn(name = "brand_id") }, inverseJoinColumns = { @JoinColumn(name = "type_id") })
    private Set<AlcoholType> alcoholTypes;
}
