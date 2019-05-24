package com.huangydyn.infustructure.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
@EqualsAndHashCode(callSuper = true)
public class AddressEntity extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "hero_id", referencedColumnName = "id", nullable = false)
    private HeroEntity hero;

    private String country;

    private String city;
}
