package dto;

import entity.Users;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class ParkingDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long parkingNumber;

    @OneToOne

    private Users users;

}
