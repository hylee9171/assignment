package com.assignment.assignment.domain;

import lombok.Getter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "locations")
@Getter
public class Location {

    @Id
    @GeneratedValue
    @Column(name="location_id")
    private int id;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;

    @OneToMany(mappedBy = "location", fetch = LAZY)
    private List<Department> departments = new ArrayList<>();

    @ManyToOne(fetch = EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;
}
