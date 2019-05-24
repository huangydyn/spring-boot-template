package com.huangydyn.representation;

import com.huangydyn.domain.Hero;
import com.huangydyn.infustructure.entity.HeroEntity;
import com.huangydyn.infustructure.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

import static com.huangydyn.utils.HeroMapper.MAPPER;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class HeroesController {

    private final HeroRepository heroRepository;

    @Autowired
    public HeroesController(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @GetMapping("/heroes/{id}")
    public HeroEntity find(@PathVariable("id") String heroId) {
        HeroEntity entity = heroRepository.findOne(heroId);
        return entity;
    }

    @DeleteMapping("/heroes/{id}")
    @Transactional
    public void deleteHero(@PathVariable("id") String heroId) {
        heroRepository.deleteById(heroId);
    }

    @GetMapping("/heroes")
    public List<Hero> query() {
        return heroRepository.findAll().stream()
                .map(MAPPER::toDomain)
                .collect(Collectors.toList());
    }

    @PutMapping("/heroes/{id}")
    public Hero update(@PathVariable("id") String heroId,
                       @RequestBody Hero hero) {
        hero.setId(heroId);
        heroRepository.save(MAPPER.toEntity(hero));
        return hero;
    }

    @PostMapping("/heroes")
    public Hero create(@RequestBody Hero hero) {
        HeroEntity entity = heroRepository.save(MAPPER.toEntity(hero));
        return MAPPER.toDomain(entity);
    }

    @PostMapping("/heroes/batch")
    public List<Hero> create(@RequestBody List<Hero> heroes) {
        List<HeroEntity> entities = heroes.stream()
                .map(MAPPER::toEntity)
                .collect(Collectors.toList());
        entities = heroRepository.save(entities);
        return entities.stream()
                .map(MAPPER::toDomain)
                .collect(Collectors.toList());
    }
}