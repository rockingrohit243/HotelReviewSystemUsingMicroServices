package com.springboot.hotelservice.Controller;

import com.springboot.hotelservice.Entity.Hotel;
import com.springboot.hotelservice.Pojo.HotelResponse;
import com.springboot.hotelservice.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping(value = "create")
    public ResponseEntity<HotelResponse> createHotel(@RequestBody Hotel hotel) {
        HotelResponse hotelResponse = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelResponse);
    }
    @GetMapping(value = "fetch/{id}")
    public Hotel fetchHotelById(@PathVariable long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.fetchById(id)).getBody();
    }
    @GetMapping(value = "fetch")
    public ResponseEntity<List<Hotel>> fetchAllHotel(){
        List<Hotel> hotelList=hotelService.fetchAllHotel();
        return ResponseEntity.status(HttpStatus.OK).body(hotelList);
    }

}
