package com.example.idcard.model.entities;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class PersonDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "details_id")
    private int detailsId;


    private String placeOfResidence;
    private String organization;
    private String militaryService;

}
