package by.javaguru.je.jdbc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.postgresql.xml.LegacyInsecurePGXmlFactoryFactory;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Airport {
    @Id
    @Column(length = 3)
    private String code;

    @Column(length = 256, nullable = false)
    private String country;

    @Column(length = 128, nullable = false)
    private String city;
}
