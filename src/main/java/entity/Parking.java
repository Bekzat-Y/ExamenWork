package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long parkingNumber;

    private String status;



}
