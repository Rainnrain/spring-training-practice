package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Ticket extends BaseEntity {
    private Integer seatNumber;
    private Integer rowNumber;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;
    @ManyToOne(fetch=FetchType.LAZY)
    private MovieCinema movieCinema;
    @ManyToOne(fetch=FetchType.LAZY)
    private User userAccount;

    @Override
    public String toString() {
        return "Ticket{" +
                "seatNumber=" + seatNumber +
                ", rowNumber=" + rowNumber +
                ", dateTime=" + dateTime +
                '}';
    }

}
