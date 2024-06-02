package com.FC.SharedOfficePlatform.domain.seat.entity;

import com.FC.SharedOfficePlatform.domain.office.entity.Office;
import com.FC.SharedOfficePlatform.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name = "seat")
@NoArgsConstructor
@Getter
public class Seat extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id", nullable = false)
    private Long seatId;

    @ManyToOne
    @JoinColumn(name = "office_id", nullable = false, insertable = false, updatable = false)
    private Office office;

    @Column(name = "office_id", nullable = false)
    private long officeId;

    @Column(name = "seat_floor")
    private int seatFloor;

    @Column(name = "seat_total")
    private int seatTotal;


    @Builder
    public Seat(
            long officeId,
            int seatFloor,
            int seatTotal
    ) {
        this.officeId = officeId;
        this.seatFloor = seatFloor;
        this.seatTotal = seatTotal;

    }

}
