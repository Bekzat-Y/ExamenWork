package controller.util;

import entity.ParkingPlace;
import entity.ParkingReservation;
import enums.ParkingSpotType;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ParkingReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservations")
public class ParkingReservationController {

    private final ParkingReservationService parkingReservationService;



    @GetMapping("/parking-places/type")
    public ResponseEntity<List<ParkingReservation>> getParkingPlacesByType(@RequestParam ParkingSpotType spotType) {
        try {
            List<ParkingReservation> parkingPlaces = parkingReservationService.getParkingPlacesByType(spotType);
            return ResponseEntity.ok(parkingPlaces);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка", e);
        }
    }


    @GetMapping("/process")
    public ResponseEntity<List<ParkingPlace>> processParkingReservations(@RequestParam ParkingSpotType spotType) {
        try {
            List<ParkingPlace> parkingPlaces = parkingReservationService.processParkingReservation(spotType);
            return ResponseEntity.ok(parkingPlaces);
        } catch (Exception e) {
            throw new RuntimeException("Не удалось обработать бронирования парковочных мест", e);
        }
    }

    @GetMapping("/parking-spots")
    public ResponseEntity<List<ParkingReservation>> getParkingPlaces() {
        List<ParkingReservation> parkingPlaces = parkingReservationService.getParkingPlaces();
        return ResponseEntity.ok(parkingPlaces);
    }
}
