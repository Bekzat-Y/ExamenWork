package controller;

import entity.Parking;
import entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ParkingService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Parking")
public class ParkingController {

private final ParkingService repo;

    @PostMapping("/insertParking")
    public ResponseEntity<Parking> insertStudent(@RequestBody Parking parking) {
        repo.insertStudent(parking);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<Parking> findAll() {
        List<Parking> students = repo.getAllParking();
        return ResponseEntity.ok((Parking) students);
    }

    @DeleteMapping("/delete/{id}")

    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        if (id != null) {
            repo.delete(id);
            return ResponseEntity.ok("200");
        } else return ResponseEntity.ok("не нашлось");
    }
    @PostMapping("/reserve")
    public String reserveParkingSpot(@RequestBody Long spotId) {
        if (repo.reserveParkingSpot(spotId)) {
            return "Парковочное место успешно забронировано";
        } else {
            return "Бронирование не удалось Парковочное место занято или не существует";
        }
    }
}
