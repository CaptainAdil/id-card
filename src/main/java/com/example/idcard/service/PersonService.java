package com.example.idcard.service;

import com.example.idcard.dto.PersonDto;
import com.example.idcard.model.Person;

import java.util.List;

public interface PersonService {

    public void createPerson(Person person);
    public void updatePerson(Person person,int id);
    public void deletePerson(int id);
    public PersonDto getPerson(int id);
    public List<PersonDto> getPersons();
    public boolean exists(int id);
}
