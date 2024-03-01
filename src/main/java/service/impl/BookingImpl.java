package service.impl;

import entity.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import repo.BookingRepo;
import service.BookingService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingImpl implements BookingService {
    private final BookingRepo repo;
    public void insert(Booking booking) {
        repo.save(booking);
    }
    public List<Booking> getAll() {
        return repo.findAll();
    }


    public Long delete(Long id) {
        Optional<Booking> optionalStudent=repo.findById(id);

        if (optionalStudent.isPresent()){
            var student = optionalStudent.get();
            repo.delete(student);
        }
        else throw new NullPointerException(String.format("DELETE: Студент с id %s не найдена", id));
        return id;
    }

    public void update(Long id, Booking booking) {
        Booking existingStudent = repo.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setParkingNumber(booking.getParkingNumber());
            existingStudent.setStatus(booking.getStatus());
            repo.save(existingStudent);
        }

    }


}
