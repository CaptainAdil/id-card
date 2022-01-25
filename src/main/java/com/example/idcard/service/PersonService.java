package com.example.idcard.service;

import com.example.idcard.dto.PersonDto;
import com.example.idcard.model.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {

    public ResponseEntity createPerson(Person person);
    public ResponseEntity updatePerson(Person person,int id);
    public ResponseEntity deletePerson(int id);
    public ResponseEntity<Object> getPerson(int id);
    public List<PersonDto> getPersons();
    public boolean exists(int id);
}
