package com.app.model;


import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class GroupTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "group")
    private Set<Person> persons = new HashSet<>();


    @Transient
    private long PersonCount;


    @Override
    public String toString() {
        return "GroupTable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", persons=" + persons +
                '}';
    }





}

