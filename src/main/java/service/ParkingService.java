package service;

import entity.Booking;
import entity.Parking;

import java.util.List;
import java.util.Optional;

public interface ParkingService {
    void insertStudent(Parking parking);

    List<Parking> getAllParking();


    void delete(Long id);


    void update(Long id , Parking parking);

    boolean reserveParkingSpot(Long spotId);

}
