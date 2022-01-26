package com.example.idcard.model.entities;


import com.example.idcard.model.enums.*;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

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


    @Enumerated(EnumType.STRING)
    private maritalStatus maritalStatus;

    private String bloodGroup;
    private String eyeColour;


    @Enumerated(EnumType.STRING)
    private gender gender;
    private int height;

    private Date dateOfIssue;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private PersonDetails personDetails;

}