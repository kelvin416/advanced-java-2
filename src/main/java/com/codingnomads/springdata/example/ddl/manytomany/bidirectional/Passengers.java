package com.codingnomads.springdata.example.ddl.manytomany.bidirectional;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Passengers {

    @Id
    @GeneratedValue
    private Long id;


    @Column(nullable = false, updatable = false)
    private String firstName;

    @Column(nullable = false, updatable = false)
    private String lastName;

    @ManyToMany(mappedBy = "passengers")
    private List<Airline> airlines;
}
