package com.huangydyn.utils;

import com.huangydyn.domain.Hero;
import com.huangydyn.infustructure.entity.HeroEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HeroMapper {

    HeroMapper MAPPER = Mappers.getMapper(HeroMapper.class);

    HeroEntity toEntity(Hero hero);

    Hero toDomain(HeroEntity hero);
}
