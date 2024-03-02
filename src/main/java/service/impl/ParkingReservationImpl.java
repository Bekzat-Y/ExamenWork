package service.impl;

import entity.ParkingPlace;
import entity.ParkingReservation;
import entity.Users;
import enums.ParkingSpotType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repo.ParkingPlaceRepo;
import repo.ParkingReservationRepo;
import repo.UsersRepo;
import service.ParkingReservationService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ParkingReservationImpl implements ParkingReservationService {

    private ParkingReservationRepo reservationRepository;

    private final ParkingPlaceRepo placeRepository;

    private final UsersRepo usersRepository;




    public List<ParkingPlace> getParkingPlacesByType(ParkingSpotType spotType) {
        return placeRepository.findBySpotType(spotType);
    }
    public boolean releaseParkingSpot(Long reservationId) {
        Optional<ParkingReservation> optionalReservation = reservationRepository.findById(reservationId);

        if (optionalReservation.isPresent()) {
            ParkingReservation reservation = optionalReservation.get();

            if (!reservation.isReleased()) {
                reservation.release();

                ParkingPlace parkingPlace = reservation.getParkingPlace();
                parkingPlace.setStatus(false);

                reservationRepository.save(reservation);
                placeRepository.save(parkingPlace);

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean reserveParkingSpot(Long userId, Long parkingPlaceId, Integer spotNumber, ParkingSpotType spotType) {
        ParkingPlace parkingPlace = placeRepository.findById(parkingPlaceId).orElse(null);
        if (parkingPlace == null ) {
            return false;         }
        Users user = usersRepository.findById(userId).orElse(null);
        if (user == null) {
            return false;
        }
        ParkingReservation reservation = new ParkingReservation();
        reservation.setUser(user);
        reservation.setParkingSpot(parkingPlace);
        reservation.setSpotNumber(Long.valueOf(spotNumber));
        reservation.setReleased(false);

        parkingPlace.setStatus(true);
        reservationRepository.save(reservation);
        return true;    }





}

