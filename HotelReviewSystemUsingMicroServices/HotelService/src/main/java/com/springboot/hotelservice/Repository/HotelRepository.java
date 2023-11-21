package com.springboot.hotelservice.Repository;

import com.springboot.hotelservice.Entity.Hotel;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
