package service;

import entity.ParkingPlace;
import entity.ParkingReservation;
import enums.ParkingSpotType;

import java.util.List;

public interface ParkingPlaceService{

    List<ParkingPlace> processParkingReservation(ParkingSpotType parkingReservation);

    boolean releaseParkingSpot(Long reservationId);
    List<ParkingReservation> getParkingPlaces();

}
