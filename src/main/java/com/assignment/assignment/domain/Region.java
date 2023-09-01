package com.assignment.assignment.domain;

import lombok.Getter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "regions")
@Getter
public class Region {

    @Id
    @GeneratedValue
    @Column(name="region_id")
    private int id;
    private String regionName;

    @OneToMany(mappedBy = "region", fetch = LAZY)
    private List<Country> countries = new ArrayList<>();
}
