package com.example.idcard;

import com.example.idcard.model.entities.Person;
import com.example.idcard.model.entities.PersonDetails;
import com.example.idcard.model.enums.gender;
import com.example.idcard.model.enums.maritalStatus;
import com.example.idcard.repository.PersonRepo;
import com.example.idcard.rest.PersonController;
import com.example.idcard.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;

@SpringBootApplication
public class IdCardApplication{

//	@Autowired
//	PersonService personService;
//
//	@Autowired
//	PersonRepo personRepo;
//
//	@Autowired
//	PersonController personController;

	public static void main(String[] args) {
		SpringApplication.run(IdCardApplication.class, args);
	}


//	@Bean
//	public CommandLineRunner populateReviews() {
//		return new ReviewPopulatorRunner();
//	}


//	public class ReviewPopulatorRunner implements CommandLineRunner {
//		@Override
//		public void run(String... args) throws Exception {
//			PersonDetails personDetails = new PersonDetails();
//			Person person = new Person("Adil","Nabiyev","Asif","Ganja",
//					"f123as",maritalStatus.SINGLE,"1","brown",gender.MALE,
//					173,new PersonDetails("Baku","Asan-xidmet","Yes"));
//
//			long id = 0;
//
//			for(id=0;id<1000000;id++) {
//				person.setId(++id);
//				personController.create(person);
//			}
//		}
//	}



}
