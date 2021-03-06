package com.example.idcard.repository;

import com.example.idcard.dto.PersonDto;
import com.example.idcard.model.entities.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person,Integer> {

    @Override
    boolean existsById(Integer integer);

    @Query(nativeQuery = true, value = "SELECT FIRST_NAME AS firstName,LAST_NAME AS lastName," +
            "FATHER_NAME AS fatherName FROM PERSON WHERE PERSON_ID = :id")
    public PersonDto findById( @Param("id") int id);


    @Query(nativeQuery = true, value = "SELECT FIRST_NAME AS firstName,LAST_NAME AS lastName," +
            "FATHER_NAME as fatherName from PERSON")
    public List<PersonDto> getAll(Pageable pageable);

    public Person findByFinCodeIgnoreCase(String finCode);
}