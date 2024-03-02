package controller.util;

import entity.ParkingReservation;
import enums.ParkingSpotType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repo.ParkingReservationRepo;

import java.util.List;

@RestController
@RequestMapping("/api/parking-processing")
public class ParkingProcessingController {

    @Autowired
    private ParkingReservationRepo reservationService;

    @GetMapping("/process")
    public ResponseEntity<List<ParkingReservation>> processParkingReservations(@RequestParam ParkingSpotType spotType) {
        try {
            List<ParkingReservation> parkingPlaces = reservationService.findByParkingSpotSpotType(spotType);
            return ResponseEntity.ok(parkingPlaces);
        } catch (Exception e) {
            throw new RuntimeException("Не удалось обработать бронирования парковочных мест.", e);
        }
    }
}