package service.impl;

import entity.ParkingReservation;
import enums.ParkingSpotType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repo.ParkingReservationRepo;
import service.ParkingReservationService;

import java.util.List;

@Service
@AllArgsConstructor
public class ParkingReservationImpl implements ParkingReservationService {

    private final ParkingReservationRepo repo;


    @Override
    public List<ParkingReservation> getParkingPlacesByType(ParkingSpotType spotType) {
        return repo.getParkingPlaceByType(spotType);
    }

    @Override
    public List<ParkingReservation> getParkingPlaces() {
        return repo.findAll();
    }
}