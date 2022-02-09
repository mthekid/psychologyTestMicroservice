package com.starlab.demo.psychology.repo;

import com.starlab.demo.psychology.model.PsychologyTestInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PsychologyTestInfoRepo extends CrudRepository<PsychologyTestInfo, Long> {
}
