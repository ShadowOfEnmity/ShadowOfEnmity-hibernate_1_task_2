package by.javaguru.je.jdbc.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"aircraft", "ticket"})
@ToString(exclude = {"aircraft", "ticket"})
@Entity
public class Seat {
    @EmbeddedId
    private SeatId id;

    @ManyToOne
    @JoinColumn(name = "aircraft_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Aircraft aircraft;

}
