package repo;

import entity.Booking;
import entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Long> {


}
