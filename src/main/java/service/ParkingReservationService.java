package service;

import entity.ParkingReservation;
import enums.ParkingSpotType;
import java.util.List;

public interface ParkingReservationService {
    List<ParkingReservation> getParkingPlacesByType(ParkingSpotType spotType);
    List<ParkingReservation> getParkingPlaces();
}
