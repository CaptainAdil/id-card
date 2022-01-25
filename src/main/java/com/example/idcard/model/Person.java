package com.example.idcard.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "First name must not be blank")
    private String firstName;

    @NotBlank(message = "lastName name must not be blank")
    private String lastName;

    @NotBlank(message = "fatherName name must not be blank")
    private String fatherName;

    private String birthPlace;

    @Column(unique = true)
    private String finCode;

    private String maritalStatus;
    private String militaryService;

    private String bloodGroup;
    private String eyeColour;
    private String gender;
    private int height;

    private String placeOfResidence;
    private String organization;

}
