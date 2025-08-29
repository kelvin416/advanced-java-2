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
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String name;

    //price in millions ksh
    @Column(name = "price(ksh)", nullable = false, updatable = false)
    private int price;

    @Column(name = "euro_rating")
    private boolean euroRated;

    @OneToOne (optional = false, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Engine engine;

    private int numberOfDaysTillPurchase;

    //check for illegality
    @PrePersist
    @PreUpdate
    private void checkIllegality(){
        if (!euroRated){
            throw new IllegalStateException("You cannot add the number of days till purchase.");
        }
    }

}
