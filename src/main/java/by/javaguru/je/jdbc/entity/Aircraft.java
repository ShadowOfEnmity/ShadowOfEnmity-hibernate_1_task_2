package by.javaguru.je.jdbc.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 128)
    private String model;

    @OneToMany(mappedBy = "aircraft")
    private List<Flight> flights = new ArrayList<>();

    @OneToMany(mappedBy = "aircraft")
    private List<Seat> seats = new ArrayList<>();
}

