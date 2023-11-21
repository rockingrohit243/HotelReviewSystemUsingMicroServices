package com.springboot.ratingservices.Service;

import com.springboot.ratingservices.Entity.Rating;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface RatingService {
    Map<Object,Object> createRating(Rating rating);
    List<Rating> fetchAllRating();
    ArrayList<Rating> fetchByUserId(String userId);
    List<Rating> fetchByHotelId(String hotelId);
}
