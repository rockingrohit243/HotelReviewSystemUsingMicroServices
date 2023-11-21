package com.springboot.ratingservices.Entity;

import com.springboot.ratingservices.Entity.pojo.Hotel;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Data
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ratingId;
    private String userId;
    private String hotelId;
    private Integer rating;
    private String remarks;
    @Transient
    public  Hotel hotel;
}
