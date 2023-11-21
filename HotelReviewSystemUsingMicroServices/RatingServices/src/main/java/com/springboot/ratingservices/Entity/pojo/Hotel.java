package com.springboot.ratingservices.Entity.pojo;

import lombok.Data;

@Data
public class Hotel {
    private long id;
    private String name;
    private String location;
    private String about;
    private String latitude;
    private String longitude;
}
