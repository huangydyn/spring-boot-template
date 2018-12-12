package com.huangydyn.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Hero {

    private String id;

    private String name;

    private String address;

    private Date createdTime;

    private Date updatedTime;
}
