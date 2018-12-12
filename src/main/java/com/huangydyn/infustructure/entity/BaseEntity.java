package com.huangydyn.infustructure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

@Data
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
abstract class BaseEntity {

    private static final int UUID_LENGTH = 32;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "id")
    @Size(max = UUID_LENGTH)
    private String id;
}
