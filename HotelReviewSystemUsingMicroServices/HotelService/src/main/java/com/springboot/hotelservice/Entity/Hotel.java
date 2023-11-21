package com.springboot.hotelservice.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "Hotel")
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String location;
    private String about;
    private String latitude;
    private String longitude;

}
