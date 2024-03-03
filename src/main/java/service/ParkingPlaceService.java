package service;

import entity.ParkingPlace;
import entity.ParkingReservation;
import enums.ParkingSpotType;


import java.util.List;

public interface ParkingPlaceService {


     ParkingPlace getParkingPlaceById(Long id);

    List<ParkingReservation> processParkingReservation(ParkingSpotType parkingReservation);

    List<ParkingPlace> getParkingPlaces();

    ParkingPlace createParkingSpot(ParkingPlace parkingPlace);

    ParkingPlace updateParkingSpot(Long id, ParkingPlace updatedParkingPlace);

    void deleteParkingSpot(Long id);
}