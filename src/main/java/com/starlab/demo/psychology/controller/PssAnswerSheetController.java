package com.starlab.demo.psychology.controller;

import com.starlab.demo.psychology.dto.PSSTestResultDTO;
import com.starlab.demo.psychology.dto.UserDTO;
import com.starlab.demo.psychology.model.PSSAnswerSheet;
import com.starlab.demo.psychology.model.User;
import com.starlab.demo.psychology.service.PsychologTestService;
import com.starlab.demo.psychology.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/psychology/test")
public class PssAnswerSheetController {


    private final UserService userService;
    private final PsychologTestService psychologTestService;

    @Autowired
    public PssAnswerSheetController(UserService userService, PsychologTestService psychologTestService) {
        this.userService = userService;
        this.psychologTestService = psychologTestService;
    }

    @GetMapping("records")
    public ResponseEntity<?> getPSSTests(@RequestParam String psychologyMedicalInfo) {
        // 사용자 정보 찾아오기

        User registeredUser = userService.checkMedicalInfo(psychologyMedicalInfo);

        List<PSSAnswerSheet> results = psychologTestService.getRecords(registeredUser);

        return ResponseEntity.ok(results);
    }

    @PostMapping("record-test")
    public ResponseEntity<?> recordPSSTest(@RequestBody PSSTestResultDTO testResultDTO) {

        User targetUser = User.builder()
                .name(testResultDTO.getName())
                .email(testResultDTO.getEmail())
                .build();

        User registeredUser = userService.findUser(targetUser);

        PSSAnswerSheet targetPssAnswerSheet = PSSAnswerSheet.builder()
                .q1(Integer.parseInt(testResultDTO.getQ1()))
                .q2(Integer.parseInt(testResultDTO.getQ2()))
                .q3(Integer.parseInt(testResultDTO.getQ3()))
                .q4(Integer.parseInt(testResultDTO.getQ4()))
                .q5(Integer.parseInt(testResultDTO.getQ5()))
                .q6(Integer.parseInt(testResultDTO.getQ6()))
                .q7(Integer.parseInt(testResultDTO.getQ7()))
                .q8(Integer.parseInt(testResultDTO.getQ8()))
                .q9(Integer.parseInt(testResultDTO.getQ9()))
                .q10(Integer.parseInt(testResultDTO.getQ10()))
                .build();

        // pssSheet 저장하기
        PSSAnswerSheet resultAnswerSheet = psychologTestService.recordPssAnswerSheet(registeredUser, targetPssAnswerSheet);
        // 사용자 정보에서 PssSheet 추가하고 저장하기.
        UserDTO resultDTO = UserDTO.builder()
            .email(resultAnswerSheet.getUser().getEmail())
            .name(resultAnswerSheet.getUser().getName())
                .build();

        return ResponseEntity.ok(resultDTO);
    }
}
