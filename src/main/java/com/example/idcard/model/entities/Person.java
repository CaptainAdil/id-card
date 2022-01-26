package com.example.idcard.model.entities;


import com.example.idcard.model.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "First name must not be blank")
    private String firstName;

    @NotBlank(message = "lastName name must not be blank")
    private String lastName;

    @NotBlank(message = "fatherName name must not be blank")
    private String fatherName;

    private String birthPlace;

    @Column(unique = true)
    private String finCode;


    @Enumerated(EnumType.STRING)
    private maritalStatus maritalStatus;

    private String bloodGroup;
    private String eyeColour;


    @Enumerated(EnumType.STRING)
    private gender gender;
    private int height;



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private PersonDetails personDetails;

    public Person(){}

    public Person(String firstName, String lastName, String fatherName, String birthPlace, String finCode, com.example.idcard.model.enums.maritalStatus maritalStatus, String bloodGroup, String eyeColour, com.example.idcard.model.enums.gender gender, int height, PersonDetails personDetails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.birthPlace = birthPlace;
        this.finCode = finCode;
        this.maritalStatus = maritalStatus;
        this.bloodGroup = bloodGroup;
        this.eyeColour = eyeColour;
        this.gender = gender;
        this.height = height;
        this.personDetails = personDetails;
    }
}