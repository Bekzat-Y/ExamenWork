package service.impl;

import entity.ParkingPlace;
import entity.ParkingReservation;
import entity.Users;
import enums.ParkingSpotType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import repo.ParkingReservationRepo;
import repo.UsersRepo;
import service.UsersService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersImpl implements UsersService {

    private final UsersRepo usersRepo;
    private final ParkingReservationRepo reservationRepository;

    @Override
    public boolean reserveParkingSpot(Long userId, Long parkingPlaceId, Integer spotNumber, ParkingSpotType spotType) {
        ParkingReservation existingReservation = reservationRepository.findById(parkingPlaceId).orElse(null);

        if (existingReservation == null || existingReservation.getParkingPlace().getStatus()) {
            return false;
        }

        Users user = usersRepo.findById(userId).orElse(null);

        if (user == null) {
            return false;
        }

        ParkingPlace parkingPlace = existingReservation.getParkingPlace();

        ParkingReservation reservation = new ParkingReservation();
        reservation.setUsers(user);
        reservation.setParkingPlace(parkingPlace);
        reservation.setSpotNumber(Long.valueOf(spotNumber));
        reservation.setReleased(false);

        parkingPlace.setStatus(true);
        reservationRepository.save(reservation);

        return true;
    }


    @Override
    public boolean releaseParkingSpot(Long reservationId) {
        Optional<ParkingReservation> optionalReservation = reservationRepository.findById(reservationId);

        if (optionalReservation.isPresent()) {
            ParkingReservation reservation = optionalReservation.get();

            if (!reservation.isReleased()) {
                reservation.setReleased(true);
                ParkingPlace parkingPlace = reservation.getParkingPlace();
                parkingPlace.setStatus(false);
                reservationRepository.save(reservation);

                return true;
            }
        }

        return false;
    }

    @Override
    public List<ParkingReservation> getParkingPlacesByType(ParkingSpotType spotType) {
        return reservationRepository.findByParkingSpotSpotType(spotType);
    }
}