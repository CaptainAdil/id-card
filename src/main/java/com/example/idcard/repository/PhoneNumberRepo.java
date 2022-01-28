package com.example.idcard.repository;

import com.example.idcard.model.entities.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumberRepo extends JpaRepository<PhoneNumber,Integer> {

    public PhoneNumber findById(int id);

    public PhoneNumber findByPhoneNumber(String phone);

}
