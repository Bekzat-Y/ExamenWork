package service.impl;

import entity.ParkingPlace;
import entity.ParkingReservation;
import enums.ParkingSpotType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repo.ParkingPlaceRepo;
import repo.ParkingReservationRepo;
import service.ParkingPlaceService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ParkingPlaceImpl implements ParkingPlaceService {

    private final ParkingReservationRepo reservationRepository;

    private final ParkingPlaceRepo placeRepository;


    public List<ParkingPlace> processParkingReservation(ParkingSpotType parkingReservation) {
        List<ParkingReservation> reservations = reservationRepository.findByParkingSpotSpotType(parkingReservation);
        List<ParkingPlace> parkingPlaces = reservations.stream()
                .map(ParkingReservation::getParkingPlace)
                .collect(Collectors.toList());

        return parkingPlaces;
    }
    public boolean releaseParkingSpot(Long reservationId) {
        Optional<ParkingReservation> optionalReservation = reservationRepository.findById(reservationId);

        if (optionalReservation.isPresent()) {
            ParkingReservation reservation = optionalReservation.get();

            if (!reservation.isReleased()) {
                reservation.release();
                entity.ParkingPlace parkingPlace = reservation.getParkingPlace();
                parkingPlace.setStatus(false);
                reservationRepository.save(reservation);
                placeRepository.save(parkingPlace);

                return true;
            }
        }

        return false;
    }

    @Override
    public List<ParkingReservation> getParkingPlaces() {
        return null;
    }

    public List<ParkingPlace> getParkingPlacesByType(ParkingSpotType spotType) {
        return placeRepository.findBySpotType(spotType);
    }


}
