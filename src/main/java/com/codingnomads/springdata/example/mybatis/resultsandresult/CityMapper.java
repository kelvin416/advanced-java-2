package com.codingnomads.springdata.example.mybatis.resultsandresult;

import jakarta.persistence.GeneratedValue;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

@Mapper
public interface CityMapper {

    @Insert("INSERT INTO mybatis.cities (name, city_country, city_population)" +
            "VALUES (#{name}, #{cityCountry}, #{cityPopulation});")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertNewCity(City city);

    @Select("SELECT * FROM mybatis.cities WHERE id = #{param1};")
    @Results(
            id = "cityResultMap",
            value = {
                    @Result(property = "cityCountry", column = "city_country"),
                    @Result(property = "cityPopulation", column = "city_population")
            }
    )
    City getCityById(Long id);

    @Select("SELECT * FROM mybatis.cities WHERE city_population > #{param1};")
    @ResultMap("cityResultMap")
    ArrayList<City> getCitiesByPopulationGreaterThan(int cityPopulation);

    @Select("SELECT * FROM mybatis.cities WHERE city_country = #{param1};")
    @ResultMap("cityResultMap")
    ArrayList<City> getCitiesByCountry(String cityCountry);

    @Delete("DELETE * FROM mybatis.cities WHERE id = #{param1};")
    void deleteByCityName(String name);
}
