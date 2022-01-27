package com.example.idcard.model.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class PersonDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    private String placeOfResidence;
    private String organization;
    private String militaryService;

    public PersonDetails(){};
    public PersonDetails(String placeOfResidence, String organization, String militaryService) {
        this.placeOfResidence = placeOfResidence;
        this.organization = organization;
        this.militaryService = militaryService;
    }

    @OneToOne
    @JoinColumn(name = "details_id")
    private Person person;

    @OneToMany (mappedBy="personDetails", fetch=FetchType.EAGER)
    private List<PhoneNumber> phoneNumbers;

}

