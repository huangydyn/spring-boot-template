package com.huangydyn.repository;

import com.huangydyn.base.IntegrationTest;
import com.huangydyn.infustructure.entity.HeroEntity;
import com.huangydyn.infustructure.repository.HeroRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;


public class HeroRepositoryTest extends IntegrationTest {

    @Autowired
    HeroRepository heroRepository;

    @Test
    public void should_create_hero() {
        HeroEntity hero = HeroEntity.builder().name("tom").address("xn").build();
        heroRepository.save(hero);
        assertNotNull(hero.getId());
    }
}
