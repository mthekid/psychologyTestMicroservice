package com.starlab.demo.psychology.repo;

import com.starlab.demo.psychology.model.UserPsychologyTestInfoOption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPsychologyTestInfoOptionRepo extends CrudRepository<UserPsychologyTestInfoOption, Long> {
}
