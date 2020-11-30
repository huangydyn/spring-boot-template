package com.huangydyn.representation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final AppService appService;

    public TestController(AppService appService) {
        this.appService = appService;
    }

    @GetMapping
    public void get() {
        appService.find();
    }
}
