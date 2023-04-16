package com.app.model;


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

    @ManyToOne()
    @JoinColumn(name = "group_ref")
    private GroupTable group;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", password='" + password + '\'' +
                ", group=" + group +
                '}';
    }
}
