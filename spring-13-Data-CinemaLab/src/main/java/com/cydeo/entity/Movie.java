package com.cydeo.entity;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Movie extends BaseEntity{

    private String name;
    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;
    private Integer duration;
    @Column(columnDefinition = "text") // removes 265 char limit-- no limit
    private String summary;
    @Enumerated (EnumType.STRING)
    private MovieType type;
    @Enumerated (EnumType.STRING)
    private MovieState state;
    private BigDecimal price;

    @ManyToMany
    @JoinTable(name="Movie_genre_rel",
    joinColumns = @JoinColumn(name="movie_id"),
    inverseJoinColumns = @JoinColumn(name="genre_id"))
    private List <Genre> genreList;
}
