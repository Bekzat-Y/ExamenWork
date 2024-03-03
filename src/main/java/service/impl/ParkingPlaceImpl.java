package service.impl;

import entity.ParkingPlace;
import entity.ParkingReservation;
import enums.ParkingSpotType;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repo.ParkingPlaceRepo;
import repo.ParkingReservationRepo;
import service.ParkingPlaceService;

import java.util.List;

@Service
@AllArgsConstructor
public class ParkingPlaceImpl implements ParkingPlaceService {

    private final ParkingReservationRepo reservationRepository;
    private final ParkingPlaceRepo placeRepository;

    @Override
    public List<ParkingReservation> processParkingReservation(ParkingSpotType parkingReservation) {
      return reservationRepository.findByParkingSpotSpotType(parkingReservation);

    }

    @Override
    public List<ParkingPlace> getParkingPlaces() {
        return placeRepository.findAll();
    }

    @Override
    public ParkingPlace createParkingSpot(ParkingPlace parkingPlace) {
        return placeRepository.save(parkingPlace);
    }

    @Override
    public ParkingPlace updateParkingSpot(Long id, ParkingPlace updatedParkingPlace) {
        ParkingPlace existingParkingPlace = getParkingPlaceById(id);

        existingParkingPlace.setParkingNumber(updatedParkingPlace.getParkingNumber());
        existingParkingPlace.setStatus(updatedParkingPlace.getStatus());
        existingParkingPlace.setParkingSpotType(updatedParkingPlace.getParkingSpotType());

        return placeRepository.save(existingParkingPlace);
    }



    @Override
    public void deleteParkingSpot(Long id) {
        placeRepository.deleteById(id);
    }

    public ParkingPlace getParkingPlaceById(Long id) {
        return placeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Parking place not found with id: " + id));
    }
}