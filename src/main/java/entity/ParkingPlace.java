package entity;

import enums.ParkingSpotType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class ParkingPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ParkingNumber;

    private Boolean status;

    private ParkingSpotType parkingSpotType;
}
