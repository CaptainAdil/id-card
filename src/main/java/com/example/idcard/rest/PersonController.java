package com.example.idcard.rest;

import com.example.idcard.dto.PersonDto;
import com.example.idcard.model.Person;
import com.example.idcard.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PersonController {

    @Autowired
    PersonRepo personRepo;

    @GetMapping("/persons")
    public List<PersonDto> getAll(){
        return personRepo.getAll();
    }

    @GetMapping("/persons/{id}")
    public Person getById(@PathVariable int id){
        return personRepo.getById(id);
    }

    @PostMapping("/update/{id}")
    public void update(@RequestBody Person person,int id){
        Person person1 = null;
        person1 = personRepo.findById(id);
        person1 = person;

        personRepo.save(person1);
    }


    @PostMapping("/create")
    public void create(@RequestBody Person person){
        personRepo.save(person);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        if(personRepo.existsById(id)){
            personRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("person with id: "+id+" is deleted");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is no person with this id");
        }
    }


}
