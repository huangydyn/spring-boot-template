package com.huangydyn.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HeroTest {

    @Test
    public void test_des() throws Exception {
        Hero hero = Hero.builder().updatedTime(new Date()).build();
        System.out.println(new ObjectMapper().writeValueAsString(hero));
    }

    @Test
    public void test_ser() throws Exception {
        Hero hero = new ObjectMapper().readValue("{\"id\":null,\"name\":null,\"address\":null,\"createdTime\":null,\"updatedTime\":\"2019-03-14\"}",
                Hero.class);
    }

    @Test
    public void name() {
        Hero hero1 = Hero.builder().id("1").build();
        Hero hero2 = Hero.builder().id("2").build();
        Hero hero3 = new Hero();
        Hero hero4 = new Hero();
        Map<String, List<Hero>> map = Arrays.asList(hero1, hero2, hero3, hero4).stream().collect(Collectors.groupingBy(hero -> hero.getId()));
        System.out.println(map);
    }

    @Test
    public void name1() {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = Stream.of(1, 2, 3, 4)
                .peek(list::add)
                .map(x -> x * 2)
                .filter(x -> x > 3)
                .collect(Collectors.toList());

        System.out.println(list);
        System.out.println(result);
    }
}
