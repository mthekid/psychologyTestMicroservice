package com.starlab.demo.psychology.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * 심리 검사지에 대한 정보들을 관리하는 테이블이다.
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PsychologyTestInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="psychology_test_id")
    private long id;

    @Column(nullable = false)
    private String testSheetName;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String targetGeneration;

    @Column(nullable = false)
    private LocalDate revisionDate;

    @Column(nullable = false)
    private int questionTotalNum;

    @OneToMany(mappedBy = "psychologyTestInfo")
    private List<UserPsychologyTestInfoOption> userPsychologyTestInfoOptions = new ArrayList<>();

    @Builder
    public PsychologyTestInfo(int id, String testSheetName, String type, String targetGeneration, LocalDate revisionDate, int questionNum ) {
        this.id = id;
        this.testSheetName = testSheetName;
        this.type = type;
        this.targetGeneration = targetGeneration;
        this.revisionDate = revisionDate;
        this.questionTotalNum = questionNum;
    }

}
