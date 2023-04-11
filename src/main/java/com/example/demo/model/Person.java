package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data

public class Person {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String firstName;
    @Column()
    private String lastName;
    @Basic(optional = false)
    @Column(nullable = false, unique = true)
    private String email;
    @Column()
    private String website;
    @Column()
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(nullable = false)
    private String password;


    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupTable group;




}
