package repo;

import entity.ParkingReservation;
import enums.ParkingSpotType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingReservationRepo extends JpaRepository<ParkingReservation, Long> {
    List<ParkingReservation> getParkingPlaceByType(ParkingSpotType spotType);
}
