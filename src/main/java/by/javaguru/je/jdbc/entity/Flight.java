package by.javaguru.je.jdbc.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"departureAirportCode", "arrivalAirportCode", "tickets"})
@ToString(exclude = {"departureAirportCode", "arrivalAirportCode", "aircraft", "tickets"})
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String flightNo;

    @Column(nullable = false)
    private LocalDateTime departureDate;

    @ManyToOne
    @JoinColumn(name = "departure_airport_code", referencedColumnName = "code", nullable = false)
    private Airport departureAirportCode;
    @Column(nullable = false)
    private LocalDateTime arrivalDate;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_code", referencedColumnName = "code", nullable = false)
    private Airport arrivalAirportCode;

    @ManyToOne
    @JoinColumn(name = "aircraft_id", nullable = false, referencedColumnName = "id")
    private Aircraft aircraft;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private FlightStatus status;

    @Builder.Default
    @OneToMany(mappedBy = "flight")
    private List<Ticket> tickets = new ArrayList<>();


}
