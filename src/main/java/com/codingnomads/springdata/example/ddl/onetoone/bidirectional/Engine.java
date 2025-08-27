package com.codingnomads.springdata.example.ddl.onetoone.bidirectional;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "engine")
@NoArgsConstructor
@Getter
@Setter
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "engine")
    private String engineName;

    @OneToOne(fetch = FetchType.EAGER,
            optional = false,
            cascade = CascadeType.PERSIST)
    private Car car;
}
