package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class MovieItem {
    private int movieId;
    private String movieName;
    private String movieGenre;
}
