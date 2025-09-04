/* CodingNomads (C)2024 */
package com.codingnomads.springdata.example.mybatis.resultsandresult;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ResultsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResultsDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadInitialData(SongMapper songMapper, CityMapper cityMapper) {
        return (args) -> {
            // notice the setter names have changed to match Java naming conventions
            Song song1 = new Song();
            song1.setName("Minnesota, WI");
            song1.setAlbumName("Bon Iver");
            song1.setArtistName("Bon Iver");
            song1.setSongLength(232);

            Song song2 = new Song();
            song2.setName("Post Humorous");
            song2.setAlbumName("Orca");
            song2.setArtistName("Gus Dapperton");
            song2.setSongLength(279);

            City city1 = new City();
            city1.setName("Nairobi");
            city1.setCityCountry("Kenya");
            city1.setCityPopulation(40);

            City city2 = new City();
            city2.setName("Mombasa");
            city2.setCityCountry("Kenya");
            city2.setCityPopulation(12);

            City city3 = new City();
            city3.setName("Lagos");
            city3.setCityCountry("Nigeria");
            city3.setCityPopulation(60);

            City city4 = new City();
            city4.setName("Abuja");
            city4.setCityCountry("Nigeria");
            city4.setCityPopulation(25);

            City city5 = new City();
            city5.setName("Alexandria");
            city5.setCityCountry("Egypt");
            city5.setCityPopulation(40);

            City city6 = new City();
            city6.setName("Cape Town");
            city6.setCityCountry("South Africa");
            city6.setCityPopulation(35);

            City city7 = new City();
            city7.setName("Johannesburg");
            city7.setCityCountry("South Africa");
            city7.setCityPopulation(55);

            City city8 = new City();
            city8.setName("Dar es Salaam");
            city8.setCityCountry("Tanzania");
            city8.setCityPopulation(33);

            City city9 = new City();
            city9.setName("Dodoma");
            city9.setCityCountry("Tanzania");
            city9.setCityPopulation(20);

            City city10 = new City();
            city10.setName("Addis Ababa");
            city10.setCityCountry("Ethiopia");
            city10.setCityPopulation(45);

            songMapper.insertNewSong(song1);
            songMapper.insertNewSong(song2);

            cityMapper.insertNewCity(city1);
            cityMapper.insertNewCity(city2);
            cityMapper.insertNewCity(city3);
            cityMapper.insertNewCity(city4);
            cityMapper.insertNewCity(city5);
            cityMapper.insertNewCity(city7);
            cityMapper.insertNewCity(city8);
            cityMapper.insertNewCity(city9);
            cityMapper.insertNewCity(city10);

            Song song3 = songMapper.getSongById(1L);
            System.out.println(song3.toString());

            City getById = cityMapper.getCityById(4L);
            System.out.println(getById);

            List<City> population = cityMapper.getCitiesByPopulationGreaterThan(30);
            population.forEach(System.out::println);

            List<City> getByCounty = cityMapper.getCitiesByCountry("Kenya");
            getByCounty.forEach(System.out::println);

            cityMapper.deleteByCityName("Dodoma");
        };
    }
}
