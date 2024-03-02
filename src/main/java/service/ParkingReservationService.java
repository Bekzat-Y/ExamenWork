package service;

import entity.ParkingPlace;
import entity.ParkingReservation;
import enums.ParkingSpotType;

import java.util.List;

public interface ParkingReservationService {

    List<ParkingPlace> getParkingPlacesByType(ParkingSpotType spotType);


    boolean reserveParkingSpot(Long userId, Long parkingPlaceId, Integer spotNumber, ParkingSpotType spotType);
}
