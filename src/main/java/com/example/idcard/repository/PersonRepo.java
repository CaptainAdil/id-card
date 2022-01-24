package com.example.idcard.repository;

import com.example.idcard.dto.PersonDto;
import com.example.idcard.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person,Integer> {



    public Person findById(int id);

    public void deleteById(int id);

    @Query(nativeQuery = true, value = "SELECT FIRST_NAME AS firstName,LAST_NAME AS lastName," +
            "FATHER_NAME as fatherName from PERSON")
    public List<PersonDto> getAll();
}
