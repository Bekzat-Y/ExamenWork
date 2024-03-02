package controller.util;

import entity.ParkingPlace;
import entity.ParkingReservation;
import enums.ParkingSpotType;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ParkingPlaceService;
import service.ParkingReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservations")
public class ParkingReservationController {


    private final ParkingPlaceService reservationService;

    private final ParkingReservationService reserveParkingSpot;

    @PostMapping("/release")
    public ResponseEntity<String> releaseParkingSpot(@RequestParam Long reservationId) {
        try {
            boolean releaseSuccessful = reservationService.releaseParkingSpot(reservationId);

            if (releaseSuccessful) {
                return ResponseEntity.ok("Место успешно освобождено.");
            } else {
                throw new NullPointerException("Бронирование не найдено или уже освобождено.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Не удалось освободить место.", e);
        }
    }
    @GetMapping("/parking-places/type")
    public ResponseEntity<List<ParkingPlace>> getParkingPlacesByType(@RequestParam ParkingSpotType spotType) {
        try {
            List<ParkingPlace> parkingPlaces = reserveParkingSpot.getParkingPlacesByType(spotType);
            return ResponseEntity.ok(parkingPlaces);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get parking places by type.", e);
        }
    }
    @PostMapping("/reserve")
    public ResponseEntity<String> reserveParkingSpot(
            @RequestParam Long userId,
            @RequestParam Long parkingPlaceId,
            @RequestParam Integer spotNumber,
            @RequestParam ParkingSpotType spotType
    ) {
        try {
            boolean reservationSuccessful = reserveParkingSpot.reserveParkingSpot(userId, parkingPlaceId, spotNumber, spotType);

            if (reservationSuccessful) {
                return ResponseEntity.ok("Место успешно забронировано.");
            } else {
                throw new NullPointerException("Место уже занято или не существует.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Не удалось забронировать место.", e);
        }
    }

    @GetMapping("/parking-places")
    public ResponseEntity<List<ParkingReservation>> getParkingPlaces() {
        List<ParkingReservation> parkingPlaces =  reservationService.getParkingPlaces();
        return ResponseEntity.ok(parkingPlaces);
    }


}