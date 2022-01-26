package com.example.idcard.model.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PersonDetails {

    @Id
    @Column(name = "details_id")
    private int detailsId;


    private String placeOfResidence;
    private String organization;
    private String militaryService;

    public PersonDetails(){};
    public PersonDetails(String placeOfResidence, String organization, String militaryService) {
        this.placeOfResidence = placeOfResidence;
        this.organization = organization;
        this.militaryService = militaryService;
    }
}

