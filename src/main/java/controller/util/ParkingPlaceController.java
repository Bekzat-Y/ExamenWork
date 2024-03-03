package controller.util;

import entity.ParkingPlace;
import enums.ParkingSpotType;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ParkingPlaceService;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/parking-processing/parking-places")
public class ParkingPlaceController {

    private final ParkingPlaceService parkingPlaceService;

    @Autowired
    public ParkingPlaceController(ParkingPlaceService parkingPlaceService) {
        this.parkingPlaceService = parkingPlaceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingPlace> getParkingPlaceById(@PathVariable Long id) {
        try {
            ParkingPlace parkingPlace = parkingPlaceService.getParkingPlaceById(id);
            return ResponseEntity.ok(parkingPlace);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ParkingPlace>> getParkingPlaces() {
        List<ParkingPlace> parkingPlaces = parkingPlaceService.getParkingPlaces();
        return ResponseEntity.ok(parkingPlaces);
    }

    @PostMapping
    public ResponseEntity<ParkingPlace> createParkingPlace(@RequestBody ParkingPlace parkingPlace) {
        try {
            ParkingPlace createdPlace = parkingPlaceService.createParkingSpot(parkingPlace);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPlace);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingPlace> updateParkingPlace(@PathVariable Long id, @RequestBody ParkingPlace updatedParkingSpot) {
        try {
            ParkingPlace updatedPlace = parkingPlaceService.updateParkingSpot(id, updatedParkingSpot);
            return ResponseEntity.ok(updatedPlace);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParkingPlace(@PathVariable Long id) {
        try {
            parkingPlaceService.deleteParkingSpot(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
