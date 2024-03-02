package entity;

import jakarta.persistence.*;
import lombok.Data;

@Data@Entity@Table
public class ParkingReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private Users users;

    @ManyToOne
    @JoinColumn(name = "parking_spot_id",nullable = false)
    private ParkingPlace parkingPlace;

    private boolean isReleased;

    public void setUser(Users user) {
        this.users = user;
    }

    public void setParkingSpot(ParkingPlace parkingPlace) {
        this.parkingPlace=parkingPlace;
    }

    private Long spotNumber;

    public void release() {
        this.isReleased = true;
    }
}
