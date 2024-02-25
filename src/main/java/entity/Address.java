package entity;

import lombok.*;

import javax.persistence.*;

@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    @Column
    private String street;
    @Column
    private String city;
}
