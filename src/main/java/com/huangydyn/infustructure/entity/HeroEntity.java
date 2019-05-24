package com.huangydyn.infustructure.entity;


import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hero")
@EqualsAndHashCode(callSuper = true)
public class HeroEntity extends BaseEntity {

    private String name;


    @OneToOne(mappedBy = "hero", cascade = CascadeType.ALL, orphanRemoval = true)
    private AddressEntity address;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "hero", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TalentEntity> talents;
}
