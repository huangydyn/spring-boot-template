package com.huangydyn.representation;

import com.alibaba.druid.pool.DruidDataSource;
import com.huangydyn.infustructure.repository.HeroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class AppService {

    private final HeroRepository heroRepository;

    private final HeroService heroService;

    @Autowired
    private DruidDataSource druidDataSource;

    public AppService(HeroRepository heroRepository, HeroService heroService) {
        this.heroRepository = heroRepository;
        this.heroService = heroService;
    }

    @Transactional
    public void find() {
        log.info("AppService start, active count : {}", druidDataSource.getActiveCount());
        heroRepository.findOne("1");
        heroService.find();
        log.info("AppService end, active count : {}", druidDataSource.getActiveCount());
    }
}
