package com.example.idcard.dto;


import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



public interface PersonDto {


    public String getFirstName();
    public String getLastName();
    public String getFatherName();

}
