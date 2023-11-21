package com.springboot.ratingservices.FeignServices;

import com.springboot.ratingservices.Entity.Rating;
import com.springboot.ratingservices.Entity.pojo.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@FeignClient(name = "HOTELSERVICE")
@Service
public interface HotelServices {

    @PostMapping(value = "hotel/create")
    Map<Object,Object> createHotel(@RequestBody Hotel hotel);

    @GetMapping(value = "hotel/fetch/{id}")
    Hotel fetchHotelById(@PathVariable long id);

    @GetMapping(value = "hotel/fetch")
    ResponseEntity<List<Hotel>> fetchAllHotel();
}
