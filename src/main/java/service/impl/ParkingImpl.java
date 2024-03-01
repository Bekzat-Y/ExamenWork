package service.impl;

import entity.Parking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repo.ParkingRepo;
import service.ParkingService;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ParkingImpl implements ParkingService {

    private final ParkingRepo repo;
    public void insertStudent(Parking studentDto) {
        repo.save(studentDto);
    }
    @Override
    public List<Parking> getAllParking() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        Optional<Parking>optionalStudent=repo.findById(id);

        if (optionalStudent.isPresent()){
            var student = optionalStudent.get();
            repo.delete(student);
        }
        else throw new NullPointerException(String.format("DELETE: Студент с id %s не найдена", id));
    }

    public void update(Long id, Parking updatedStudent) {
        Parking existingStudent = repo.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setParkingNumber(updatedStudent.getParkingNumber());
            repo.save(existingStudent);
        }

    }

    public boolean reserveParkingSpot(Long spotId) {
        Parking parkingSpot = repo.findById(spotId).orElse(null);

        if (parkingSpot != null && "Свободно ".equals(parkingSpot.getStatus())) {
            parkingSpot.setStatus("Занят");
            repo.save(parkingSpot);
            return true;
        }

        return false;
    }

}
