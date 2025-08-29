package com.codingnomads.springdata.example.dml.derivedquerymethods.myexample;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String model;

    @Column(name = "year", nullable = false)
    private Integer yearOfManufacture;

}
