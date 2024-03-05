package service;

import entity.ParkingPlace;
import java.util.List;

public interface ParkingPlaceService {
    ParkingPlace getParkingPlaceById(Long id);
    List<ParkingPlace> getParkingPlaces();
    ParkingPlace createParkingSpot(ParkingPlace parkingPlace);
    ParkingPlace updateParkingSpot(Long id, ParkingPlace updatedParkingPlace);
    void deleteParkingSpot(Long id);
}
