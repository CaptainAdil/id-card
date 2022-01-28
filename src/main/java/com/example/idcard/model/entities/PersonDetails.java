package com.example.idcard.model.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class PersonDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="details_id")
    private int id;


    private String placeOfResidence;
    private String organization;
    private String militaryService;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;


//    @JsonBackReference
    @OneToMany (mappedBy="personDetails", cascade = CascadeType.ALL)
    private List<PhoneNumber> phoneNumbers;

    public PersonDetails() {
    }

    public PersonDetails(String placeOfResidence, String organization, String militaryService, Person person, List<PhoneNumber> phoneNumbers) {
        this.placeOfResidence = placeOfResidence;
        this.organization = organization;
        this.militaryService = militaryService;
        this.person = person;
        this.phoneNumbers = phoneNumbers;
    }
}

