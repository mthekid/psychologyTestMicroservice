package com.starlab.demo.psychology.repo;

import com.starlab.demo.psychology.model.PSSAnswerSheet;
import com.starlab.demo.psychology.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PSSAnswerSheetRepo extends CrudRepository<PSSAnswerSheet, Long> {

    public List<PSSAnswerSheet> findAllByUser(User user);
}
