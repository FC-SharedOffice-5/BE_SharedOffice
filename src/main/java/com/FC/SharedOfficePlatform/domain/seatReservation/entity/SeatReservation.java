package com.FC.SharedOfficePlatform.domain.seatReservation.entity;

import com.FC.SharedOfficePlatform.domain.seat.entity.Seat;
import com.FC.SharedOfficePlatform.global.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "seat_reservation")
@NoArgsConstructor
@Getter
public class SeatReservation extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_res_id", nullable = false)
    private Long seatResId;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false, insertable=false, updatable=false)
    private Seat seat;

    @Column(name = "seat_id", nullable = false)
    private long seatId;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "seat_res_num")
    private String seatResNum;

    @Column(name = "seat_res_start_date")
    private LocalDateTime seatResStartDate;

    @Column(name = "seat_res_end_date")
    private LocalDateTime seatResEndDate;

    @Builder
    public SeatReservation(
            long seatId,
            Long memberId,
            String seatResNum,
            LocalDateTime seatResStartDate,
            LocalDateTime seatResEndDate
    ) {
        this.seatId = seatId;
        this.memberId = memberId;
        this.seatResNum = seatResNum;
        this.seatResStartDate = seatResStartDate;
        this.seatResEndDate = seatResEndDate;
    }

}
