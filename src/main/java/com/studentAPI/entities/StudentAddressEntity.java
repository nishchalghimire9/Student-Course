package com.studentAPI.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class StudentAddressEntity {
    @Id
    @GeneratedValue (strategy=GenerationType .IDENTITY )
    private int id;
    @Column(unique = true)
    private String streetAddress;
    private String city;
    private String state;
    private int zipcode;

    @OneToOne
    @JoinColumn(name = "student_Id")  // one address belongs to one student
    private StudentEntity studentEntity;


}
