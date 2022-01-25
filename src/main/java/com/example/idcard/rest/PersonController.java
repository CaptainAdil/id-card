package com.example.idcard.rest;

import com.example.idcard.dto.PersonDto;
import com.example.idcard.model.Person;
import com.example.idcard.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/persons")
    public List<PersonDto> getAll(){
        return personService.getPersons();
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id){
        if(personService.exists(id)){
            return ResponseEntity.status(HttpStatus.OK).body(personService.getPerson(id));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no person with id: "+id);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody Person person,@PathVariable int id){
        if(personService.exists(id)){
            personService.updatePerson(person,id);
            return ResponseEntity.status(HttpStatus.OK).body("Person with id:"+id+" is updated!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no person with id: "+id);
        }
    }


    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Person person){
            personService.createPerson(person);

            return ResponseEntity.status(HttpStatus.CREATED).body("New Person is created!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        if(personService.exists(id)){
            personService.deletePerson(id);
            return ResponseEntity.status(HttpStatus.OK).body("person with id: "+id+" is deleted");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no person with this id");
        }
    }


}
