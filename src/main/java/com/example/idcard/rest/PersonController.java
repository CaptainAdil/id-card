package com.example.idcard.rest;

import com.example.idcard.dto.PersonDto;
import com.example.idcard.model.entities.Person;
import com.example.idcard.repository.PersonRepo;
import com.example.idcard.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public List<PersonDto> getAll(Pageable pageable){
        return personService.getPersons(pageable);
    }


    @GetMapping("/persons/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id){
        return personService.getPerson(id);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody Person person,@PathVariable int id){
        return personService.updatePerson(person,id);
    }


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Person person){
            return personService.createPerson(person);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        return personService.deletePerson(id);
    }

}