package by.javaguru.je.jdbc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SeatId implements Serializable {

    @Serial
    private static final long serialVersionUID = 7718890686897982078L;

    @Column(name = "seat_no")
    private String seatNo;

    @Column(name = "aircraft_id")
    private Long aircraft;

}
