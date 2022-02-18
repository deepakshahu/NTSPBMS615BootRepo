package com.nit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nit.document.DrivingLicense;

public interface IDrivingLicenseRepo extends MongoRepository<DrivingLicense, Long>{

}
