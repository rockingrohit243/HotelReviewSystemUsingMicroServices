package com.springboot.ratingservices.Repository;

import com.springboot.ratingservices.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,String> {
    ArrayList<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);
}
