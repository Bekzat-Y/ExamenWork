package service.impl;

import entity.ParkingPlace;
import entity.ParkingReservation;
import enums.ParkingSpotType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import service.ParkingReservationService;

import java.util.List;

@Service
@AllArgsConstructor
public class ParkingReservationImpl implements ParkingReservationService {

    @Override
    public List<ParkingPlace> findParkingPlacesByType(ParkingSpotType spotType) {
        return null;
    }

    @Override
    public List<ParkingPlace> processParkingReservation(ParkingSpotType parkingReservation) {
        return null;
    }

    @Override
    public List<ParkingReservation> getParkingPlacesByType(ParkingSpotType spotType) {
        return null;
    }

    @Override
    public List<ParkingReservation> getParkingPlaces() {
        return null;
    }

}