package com.huangydyn.infustructure.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "talent")
public class TalentEntity extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "hero_id", referencedColumnName = "id", nullable = false)
    private HeroEntity hero;

    private String name;

}
