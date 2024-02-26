package entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Builder
@Entity
@Table
@ToString
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private int age;

    @ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinTable(name = "people_address",
            joinColumns ={@JoinColumn(name="people_id")},
            inverseJoinColumns = {@JoinColumn(name="address_id")}
    )
    private Set<Address> addresses;
}
