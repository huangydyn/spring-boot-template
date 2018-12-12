package com.huangydyn.representation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/v1/config")
public class ConfigController {

    @Value("${test.value}")
    private String configValue;

    @GetMapping("/value")
    public Config getConfig() {
        return Config.builder().configValue(configValue).date(new Date()).build();
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Config {

        private String configValue;

        private Date date;
    }
}
