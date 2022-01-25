package com.example.idcard.service;

import com.example.idcard.dto.PersonDto;
import com.example.idcard.model.Person;
import com.example.idcard.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepo personRepo;

    @Override
    public void createPerson(Person person) {
        personRepo.save(person);
    }

    @Override
    public void updatePerson(Person person,int id) {
        Person person1 = personRepo.getById(id);
        person1.setFatherName(person.getFatherName());
        person1.setFirstName(person.getFirstName());
        person1.setLastName(person.getLastName());
        personRepo.save(person1);
    }

    @Override
    public void deletePerson(int id) {
        personRepo.deleteById(id);
    }


    @Override
    public List<PersonDto> getPersons() {
        return personRepo.getAll();
    }

    @Override
    public PersonDto getPerson(int id) {
        return personRepo.findById(id);
    }

    @Override
    public boolean exists(int id) {
        return personRepo.existsById(id);
    }
}
