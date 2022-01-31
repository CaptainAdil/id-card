package com.example.idcard.service.person;

import com.example.idcard.dto.PersonDto;
import com.example.idcard.model.entities.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonService {

    public ResponseEntity createPerson(Person person);
    public ResponseEntity updatePerson(Person person,int id);
    public ResponseEntity deletePerson(int id);
    public ResponseEntity<Object> getPerson(int id);
    public List<PersonDto> getPersons(Pageable pageable);
    public boolean exists(int id);
    public boolean finCodeChecker(Person person);

    public String getAlphaNumericString();
}
