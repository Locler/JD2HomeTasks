package entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("H")
public class HomeTask extends Task {
    @Column
    @CreationTimestamp
    private LocalDateTime startTime;
    @Column
    @CreationTimestamp
    private LocalDateTime endTime;
    @Column
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "home_task_city")),
            @AttributeOverride(name = "street", column = @Column(name = "home_task_street"))
    })
    private Address address;
}
