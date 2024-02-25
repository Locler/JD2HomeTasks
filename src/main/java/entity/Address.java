package entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = "people")
@Builder
@Entity
@Table
@ToString(exclude = "people")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String street;

    @Column(name="house_count")
    private int houseCount;

    @ManyToMany(mappedBy = "addresses")
    private Set<People> people;


}
