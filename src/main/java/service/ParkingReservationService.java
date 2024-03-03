package service;

import entity.ParkingPlace;
import entity.ParkingReservation;
import enums.ParkingSpotType;

import java.util.List;

public interface ParkingReservationService {
    List<ParkingPlace> findParkingPlacesByType(ParkingSpotType spotType);

    List<ParkingPlace> processParkingReservation(ParkingSpotType parkingReservation);


    List<ParkingReservation> getParkingPlacesByType(ParkingSpotType spotType);

    List<ParkingReservation> getParkingPlaces();
}