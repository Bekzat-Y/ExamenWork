package entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;



}
