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
@Getter
@Setter
public class Airline {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Passengers> passengers;
}
