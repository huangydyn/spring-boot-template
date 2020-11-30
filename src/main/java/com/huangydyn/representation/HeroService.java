package com.huangydyn.representation;

import com.alibaba.druid.pool.DruidDataSource;
import com.huangydyn.infustructure.repository.HeroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class HeroService {
    private final HeroRepository heroRepository;

    @Autowired
    private DruidDataSource druidDataSource;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void find() {
        log.info("HeroService start, active count : {}", druidDataSource.getActiveCount());
        heroRepository.findAll();
        log.info("HeroService end, active count : {}", druidDataSource.getActiveCount());
    }
}
