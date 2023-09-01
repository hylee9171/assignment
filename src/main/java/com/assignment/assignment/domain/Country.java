package com.assignment.assignment.domain;

import lombok.Getter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "countries")
@Getter
public class Country {

    @Id
    @GeneratedValue
    @Column(name="country_id")
    private String id;
    private String countryName;

    @OneToMany(mappedBy = "country", fetch = LAZY)
    private List<Location> locations = new ArrayList<>();

    @ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "region_id")
    private Region region;

}
