package repo;

import entity.ParkingPlace;
import enums.ParkingSpotType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingPlaceRepo extends JpaRepository<ParkingPlace , Long> {
    List<ParkingPlace> findBySpotType(ParkingSpotType spotType);
}
