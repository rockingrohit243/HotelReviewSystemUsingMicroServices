package com.springboot.ratingservices.Service.impl;

import com.springboot.ratingservices.Entity.Rating;
import com.springboot.ratingservices.Entity.pojo.Hotel;
import com.springboot.ratingservices.Exception.ResourceNotFoundException;
import com.springboot.ratingservices.FeignServices.HotelServices;
import com.springboot.ratingservices.Repository.RatingRepository;
import com.springboot.ratingservices.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    RatingRepository ratingRepository;
    @Autowired
    HotelServices hotelServices;

    @Override
    public Map<Object, Object> createRating(Rating rating) {
        ratingRepository.save(rating);
        Map<Object, Object> response = new HashMap<>();
        response.put("status", 0);
        response.put("message", "Thank you for giving rating.");
        return response;
    }

    @Override
    public List<Rating> fetchAllRating() {
        List<Rating> ratingList = ratingRepository.findAll();
        if (ratingList.isEmpty()) {
            throw new RuntimeException();
        }
        return ratingList.stream().peek(rating -> {

            Hotel hotel = hotelServices.fetchHotelById(Long.parseLong(rating.getHotelId()));
            rating.setHotel(hotel);
        }).collect(Collectors.toList());
    }

    @Override
    public ArrayList<Rating> fetchByUserId(String userId) {
        ArrayList<Rating> ratingList = ratingRepository.findByUserId(userId);
        if (ratingList.isEmpty()) {
            throw new ResourceNotFoundException(userId);
        }
        return ratingList;
    }

    @Override
    public List<Rating> fetchByHotelId(String hotelId) {
        List<Rating> ratingList = ratingRepository.findByHotelId(hotelId);
        if (ratingList.isEmpty()) {
            throw new ResourceNotFoundException(hotelId);
        }
        return ratingList;
    }
}
