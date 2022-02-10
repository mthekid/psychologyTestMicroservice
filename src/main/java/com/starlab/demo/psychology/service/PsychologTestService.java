package com.starlab.demo.psychology.service;

import com.starlab.demo.psychology.model.PSSAnswerSheet;
import com.starlab.demo.psychology.model.User;
import com.starlab.demo.psychology.repo.PSSAnswerSheetRepo;
import com.starlab.demo.psychology.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PsychologTestService {

    @Autowired
    private PSSAnswerSheetRepo pssAnswerSheetRepo;

    @Autowired
    private UserRepo userRepo;

    public PSSAnswerSheet recordPssAnswerSheet(User user, PSSAnswerSheet pssAnswerSheet) {

        pssAnswerSheet.setUser(user);
        System.out.println("사용자 식별번호 " + user.getId());
        return pssAnswerSheetRepo.save(pssAnswerSheet);
    }

    public List<PSSAnswerSheet> getRecords(User user) {
        return pssAnswerSheetRepo.findAllByUser(user);
    }

}
