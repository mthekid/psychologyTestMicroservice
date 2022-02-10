package com.starlab.demo.psychology.service;

import com.starlab.demo.psychology.model.PSSAnswerSheet;
import com.starlab.demo.psychology.model.User;
import com.starlab.demo.psychology.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User createUser(final User user) {
        if(user == null) {
            throw new RuntimeException("사용자 입력값으로 null이 입력되었습니다.");
        }

        if(userRepo.existsByNameAndEmail(user.getEmail(), user.getName())) {
            log.warn("사용자에 대한 정보가 이미 존재합니다. 이름 : {} 이메일 : ", user.getName(), user.getEmail());
            throw new RuntimeException("해당 사용자가 이미 존재합니다.");
        }

        return userRepo.save(user);
    }

    public User findUser(User user) {
        return  userRepo.findByNameAndEmail(user.getName(), user.getEmail());
    }

    public User addTestRecord(User user, PSSAnswerSheet pssAnswerSheet) {
        return userRepo.save(user);
    }

    public User checkMedicalInfo(String medicalInfo) {
        return userRepo.findByMedicalInfo(medicalInfo);
    }
}
