package com.codingnomads.springdata.example.mybatis.resultsandresult;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class City {


    private Long id;

    private String name;

    private String cityCountry;

//    population in millions
    private int cityPopulation;

    public City(Long id, String name, String cityCountry, int cityPopulation) {
        this.id = id;
        this.name = name;
        this.cityCountry = cityCountry;
        this.cityPopulation = cityPopulation;
    }
}
