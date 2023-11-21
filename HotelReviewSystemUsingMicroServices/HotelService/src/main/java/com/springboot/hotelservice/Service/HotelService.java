package com.springboot.hotelservice.Service;

import com.springboot.hotelservice.Entity.Hotel;
import com.springboot.hotelservice.Pojo.HotelResponse;

import java.util.List;

public interface HotelService {
    HotelResponse createHotel(Hotel hotel);

    Hotel fetchById(long id);

    List<Hotel> fetchAllHotel();
}
