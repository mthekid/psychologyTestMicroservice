package com.starlab.demo.psychology.repo;

import com.starlab.demo.psychology.model.PSSAnswerSheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PSSAnswerSheetRepo extends CrudRepository<PSSAnswerSheet, Long> {
}
