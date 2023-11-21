package com.springboot.ratingservices.Controller;

import com.springboot.ratingservices.Entity.Rating;
import com.springboot.ratingservices.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "rating")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @PostMapping(value = "create")
    public ResponseEntity<Map<Object, Object>> createRating(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.createRating(rating));
    }

    @GetMapping(value = "fetch")
    public ResponseEntity<List<Rating>> fetchAllRatings() {
        return ResponseEntity.ok(ratingService.fetchAllRating());
    }

    @GetMapping(value = "fetchByUserId/{userId}")
    public ResponseEntity<ArrayList<Rating>> fetchRatingByUserId(@PathVariable String userId)
    {
        return ResponseEntity.ok(ratingService.fetchByUserId(userId));
    }
    @GetMapping(value = "fetchByHotelId/{hotelId}")
    public ResponseEntity<List<Rating>> fetchRatingByHotelId(@PathVariable String hotelId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.fetchByHotelId(hotelId));
    }

}
