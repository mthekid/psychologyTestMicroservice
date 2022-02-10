package com.starlab.demo.psychology.repo;

import com.starlab.demo.psychology.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    boolean existsByNameAndEmail(String name, String email);
    User findByNameAndEmail(String name, String email);
    User findByMedicalInfo(String medicalInfo);
}
