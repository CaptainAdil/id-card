package com.example.idcard.repository;

import com.example.idcard.model.entities.PersonDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDetailsRepo extends JpaRepository<PersonDetails,Integer> {

    boolean existsById(Integer integer);

    public void deleteById(Integer id);

    public PersonDetails getById(Integer integer);
}
