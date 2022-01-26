package com.example.idcard.repository;

import com.example.idcard.model.entities.PersonDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDetailRepo extends JpaRepository<PersonDetails,Integer> {

}
