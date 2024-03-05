package service;

import entity.ParkingReservation;
import enums.ParkingSpotType;
import java.util.List;

public interface UsersService {
    boolean reserveParkingSpot(Long userId, Long parkingPlaceId, Integer spotNumber, ParkingSpotType spotType);
    boolean releaseParkingSpot(Long reservationId);
    List<ParkingReservation> getParkingPlacesByType(ParkingSpotType spotType);
}
