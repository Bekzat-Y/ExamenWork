package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class ParkingReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "parking_spot_id", nullable = false)
    private ParkingPlace parkingPlace;

    private boolean isReleased;

    private Long spotNumber;
}
