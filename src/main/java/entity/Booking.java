package entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table
@Data
public class Booking {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Long parkingNumber;

        private String status;

}
