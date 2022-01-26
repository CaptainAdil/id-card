package com.example.idcard.service;

import com.example.idcard.dto.PersonDto;
import com.example.idcard.model.entities.Person;
import com.example.idcard.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepo personRepo;

    @Override
    public ResponseEntity createPerson(Person person) {
        if(finCodeChecker(person)){
            personRepo.save(person);
            return ResponseEntity.status(HttpStatus.CREATED).body("New person is created!");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Person with this fincode is already exist!");
        }

    }

    @Override
    public ResponseEntity updatePerson(Person person,int id) {
        if(exists(id)){
            Person person1 = personRepo.getById(id);
            person1.setFatherName(person.getFatherName());
            person1.setFirstName(person.getFirstName());
            person1.setLastName(person.getLastName());
            personRepo.save(person);

            return ResponseEntity.status(HttpStatus.OK).body("Person with id:"+id+" is updated!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no person with id: "+id);
        }

    }

    @Override
    public ResponseEntity deletePerson(int id) {
        if(exists(id)){
            personRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("person with id: "+id+" is deleted");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no person with this id");
        }
    }


    @Override
    public List<PersonDto> getPersons() {
        return personRepo.getAll();
    }

    @Override
    public ResponseEntity<Object> getPerson(int id) {
        if(exists(id)){
            return ResponseEntity.status(HttpStatus.OK).body(personRepo.findById(id));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no person with id: "+id);
        }
    }

    @Override
    public boolean exists(int id) {
        return personRepo.existsById(id);
    }

    @Override
    public boolean finCodeChecker(Person person) {

        Person person1 = personRepo.findByFinCodeIgnoreCase(person.getFinCode());

        if(person1==null){
            return true;
        }else{
            person.setFinCode(getAlphaNumericString());
            return true;
        }

    }

    public String getAlphaNumericString(){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(6);

        for(int i = 0;i<6;i++){
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }


}