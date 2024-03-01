package service;

import entity.Booking;
import entity.Users;

import java.util.List;

public interface BookingService {

    void insert(Booking booking);

    List<Booking> getAll();


    Long delete(Long id);


    void update(Long id , Booking booking);

}
