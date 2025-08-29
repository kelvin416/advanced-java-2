package com.codingnomads.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CarApplication implements CommandLineRunner {

    @Autowired
    CarRepo carRepo;

    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {

        Engine toyotaEngine = Engine.builder().model("toyota").yearOfManufacture(2019).build();
        Engine hondaEngine = Engine.builder()
                .model("honda")
                .yearOfManufacture(2022)
                .build();
        Engine fordEngine = Engine.builder()
                .model("ford")
                .yearOfManufacture(2020)
                .build();
        Engine bmwEngine = Engine.builder()
                .model("bmw")
                .yearOfManufacture(2023)
                .build();

        Car benz = Car.builder().name("benz").price(89000).euroRated(true).engine(bmwEngine).numberOfDaysTillPurchase(22).build();
//        Car x5 = Car.builder()
//                .name("x5")
//                .price(75000)
//                .euroRated(true)
//                .engine(bmwEngine)
//                .numberOfDaysTillPurchase(5)
//                .build();
        Car crv = Car.builder()
                .name("crv")
                .price(33000)
                .euroRated(true)
                .engine(hondaEngine)
                .numberOfDaysTillPurchase(20)
                .build();
        Car mustang = Car.builder()
                .name("mustang")
                .price(55000)
                .euroRated(true)
                .engine(fordEngine)
                .numberOfDaysTillPurchase(30)
                .build();

        Car prius = Car.builder()
                .name("prius")
                .price(35000)
                .euroRated(true)
                .engine(toyotaEngine)
                .numberOfDaysTillPurchase(8)
                .build();
//
//        Car accord = Car.builder()
//                .name("accord")
//                .price(29000)
//                .euroRated(false)
//                .engine(hondaEngine)
//                .numberOfDaysTillPurchase(12)
//                .build();
//
//        Car series3 = Car.builder()
//                .name("3series")
//                .price(41000)
//                .euroRated(true)
//                .engine(bmwEngine)
//                .numberOfDaysTillPurchase(10)
//                .build();

//        Using save all method
//        carRepo.saveAll(List.of(benz, x5, crv, mustang, prius, accord, series3));

        carRepo.save(benz);
//        carRepo.save(x5);
        carRepo.save(crv);
        carRepo.save(mustang);
        carRepo.save(prius);
//        carRepo.save(accord);
//        carRepo.save(series3);

        System.out.println("\n**********findByName**********");
        List<Car> car1 = carRepo.findByName("benz");
        car1.forEach(System.out::println);




    }
}
