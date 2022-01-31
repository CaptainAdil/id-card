package com.example.idcard.service.person;

import com.example.idcard.dto.PersonDto;
import com.example.idcard.model.entities.Person;
import com.example.idcard.model.entities.PersonDetails;
import com.example.idcard.model.entities.PhoneNumber;
import com.example.idcard.repository.PersonDetailsRepo;
import com.example.idcard.repository.PersonRepo;
import com.example.idcard.repository.PhoneNumberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepo personRepo;

    @Autowired
    PhoneNumberRepo phoneNumberRepo;

    @Autowired
    PersonDetailsRepo personDetailsRepo;

    @Override
    public ResponseEntity createPerson(Person person) {

        System.out.println(person.getFinCode());
        if(finCodeChecker(person)){
            PersonDetails personDetails = person.getPersonDetails();
            personDetails.setPerson(person);


            for(int i=0;i<personDetails.getPhoneNumbers().size();i++){
                if(!phoneNumberChecker(person.getPersonDetails().getPhoneNumbers().get(i))){
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The phone number already exists");
                }
                person.getPersonDetails().getPhoneNumbers().get(i).setPersonDetails(personDetails);
            }

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
    public List<PersonDto> getPersons(Pageable pageable) {
        return personRepo.getAll(pageable);
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
            return false;
        }

    }

    public String getAlphaNumericString(){
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(AlphaNumericString.length());

        for(int i = 0;i<AlphaNumericString.length();i++){
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public boolean phoneNumberChecker(PhoneNumber phoneNumber){
        PhoneNumber phoneNumber1= phoneNumberRepo.findByPhoneNumber(phoneNumber.getPhoneNumber());
        if(phoneNumber1 == null){
            return true;
        }else {
            return false;
        }
    }

}