package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewMovie {
    private int movieId;
    private String pictureUrl;
    private String movieName;
    private String movieGenre;
}
