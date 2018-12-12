package com.huangydyn.infustructure.repository;


import com.huangydyn.infustructure.entity.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<HeroEntity, String> {

    void deleteById(String id);
}