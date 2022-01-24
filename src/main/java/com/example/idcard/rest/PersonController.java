package com.example.idcard.rest;

import com.example.idcard.dto.PersonDto;
import com.example.idcard.model.Person;
import com.example.idcard.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
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



    @PostMapping("/create")
    public void create(@RequestBody Person person){
        personRepo.save(person);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        personRepo.deleteById(id);
    }


}
