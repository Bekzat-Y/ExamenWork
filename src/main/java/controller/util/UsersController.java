package controller.util;

import entity.ParkingReservation;
import enums.ParkingSpotType;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UsersService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @PostMapping("/reserve")
    public ResponseEntity<String> reserveParkingSpot(
            @RequestParam Long userId,
            @RequestParam Long parkingPlaceId,
            @RequestParam Integer spotNumber,
            @RequestParam ParkingSpotType spotType
    ) {
        try {
            boolean reservationSuccessful = usersService.reserveParkingSpot(userId, parkingPlaceId, spotNumber, spotType);

            if (reservationSuccessful) {
                return ResponseEntity.ok("Место успешно забронировано");
            } else {
                throw new RuntimeException("Место уже занято или не существует");
            }
        } catch (Exception e) {
            throw new RuntimeException("Не удалось забронировать место", e);
        }
    }

    @PostMapping("/release")
    public ResponseEntity<String> releaseParkingSpot(@RequestParam Long reservationId) {
        try {
            boolean releaseSuccessful = usersService.releaseParkingSpot(reservationId);

            if (releaseSuccessful) {
                return ResponseEntity.ok("Место успешно освобождено");
            } else {
                throw new RuntimeException("Бронирование не найдено или уже освобождено");
            }
        } catch (Exception e) {
            throw new RuntimeException("Не удалось освободить место", e);
        }
    }

    @GetMapping("/parking-places/type")
    public ResponseEntity<List<ParkingReservation>> getParkingPlacesByType(@RequestParam ParkingSpotType spotType) {
        try {
            List<ParkingReservation> parkingPlaces = usersService.getParkingPlacesByType(spotType);
            return ResponseEntity.ok(parkingPlaces);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка", e);
        }
    }
}
