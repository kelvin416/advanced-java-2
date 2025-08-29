package com.codingnomads.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {

//    Introducer Variation

    List<Car> findByName(String name);
    List<Car> queryByName(String name);
    List<Car> getByName(String name);
    List<Car> readByName(String name);

//    Similarity keyword

    List<Car> findByNameStartingWith(String namePrefix);
    List<Car> findByNameEndingWith(String nameSuffix);
    List<Car> findByNameContaining(String pattern);

//    Distinct keywords
    List<Car> findDistinctFirst5ByEngine_model(String model);
    List<Car> findDistinctFirst5ByPriceGreaterThan(int price);
    List<Car> findLastDistinct5ByEuroRatedIsTrue();


//    Limiting Keyword
    Car findFirstByPriceGreaterThan(int price);
//    List<Car> findFirst5Engine_yearOfManufactureLessThan(int yearOfManufacture);

//    Paging and Sorting

    Page<Car> findByNameContaining(String pattern, Pageable pageable);

//    Multiple Conditions
    List<Car> findByEngine_modelAndEngine_yearOfManufacture(String model, Integer yearOfManufacture);
}
