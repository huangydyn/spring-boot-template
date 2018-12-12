package com.huangydyn.representation;

import com.huangydyn.domain.Hero;
import com.huangydyn.infustructure.entity.HeroEntity;
import com.huangydyn.infustructure.repository.HeroRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class HeroesControllerTest extends UnitTest {

    @Mock
    HeroRepository heroRepository;

    @InjectMocks
    HeroesController heroesController;

    @Test
    public void should_create_hero() {
        Hero hero = new Hero();
        heroesController.create(hero);
        verify(heroRepository).save(any(HeroEntity.class));
    }
}