package com.springboot.hotelservice.ServiceImpl;

import com.springboot.hotelservice.Entity.Hotel;
import com.springboot.hotelservice.Exception.ResourceNotFoundException;
import com.springboot.hotelservice.Pojo.HotelResponse;
import com.springboot.hotelservice.Repository.HotelRepository;
import com.springboot.hotelservice.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;
    @Override
    public HotelResponse createHotel(Hotel hotel) {
         hotelRepository.save(hotel);
         return new HotelResponse("0","Successfully created...");
    }

    @Override
    public Hotel fetchById(long id) {
        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(id) );
    }

    @Override
    public List<Hotel> fetchAllHotel() {
        return hotelRepository.findAll(Sort.by("id"));
    }
}
