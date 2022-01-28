package com.example.idcard.model.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Entity
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private int id;

    @Pattern(regexp="^\\+?\\d{3}[-.\\s]?\\(?\\d{2}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{2}[-.\\s]?\\d{2}?")
    private String phoneNumber;


    @ManyToOne()
    @JoinColumn (name = "details_id")
    private PersonDetails personDetails;

    public PhoneNumber() {
    }

    public PhoneNumber(String phoneNumber, PersonDetails personDetails) {
        this.phoneNumber = phoneNumber;
        this.personDetails = personDetails;
    }
}
