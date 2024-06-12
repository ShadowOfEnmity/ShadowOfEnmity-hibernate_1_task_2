package by.javaguru.je.jdbc.entity;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import lombok.*;
import org.hibernate.annotations.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "flight")
@ToString(exclude = "flight")
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32, nullable = false)
    public String passportNo;
    @Column(length = 128, nullable = false)
    private String passengerName;


    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "id", nullable = false, insertable = true, updatable = false)
    private Flight flight;



    @Column(name = "seat_no", nullable = false)
    String seatNo;


    @Column(nullable = false)
    private BigDecimal cost;

}
