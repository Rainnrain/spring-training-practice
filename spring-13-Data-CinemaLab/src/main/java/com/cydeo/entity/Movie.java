package com.cydeo.entity;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Movie extends BaseEntity{

    private String name;
    @Column(columnDefinition = "DATE")
    private LocalDate releateDate;
    private Integer duration;
    @Column(columnDefinition = "text") // removes 265 char limit-- no limit
    private String summary;
    @Enumerated (EnumType.STRING)
    private MovieType type;
    @Enumerated (EnumType.STRING)
    private MovieState state;
    private BigDecimal price;
}
