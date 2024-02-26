package entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;


@Entity
@ToString
@SuperBuilder
@Table
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="task_id")
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