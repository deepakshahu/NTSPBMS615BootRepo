package com.nit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.PhoneNumber;

public interface IPhoneNumberRepo extends JpaRepository<PhoneNumber, Integer> {

}
