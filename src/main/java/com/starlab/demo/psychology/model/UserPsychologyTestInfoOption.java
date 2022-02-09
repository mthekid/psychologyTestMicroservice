package com.starlab.demo.psychology.model;

import jdk.jfr.Timestamp;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserPsychologyTestInfoOption {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_psychologyTest_con_id")
    private long id;

    // 사용자 테이블 1 : 검사정보 공개 옵션 설정 * 관계를 가진다.
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // 심리검사 테이블 1 : 해당 테이블 다 관계를 가진다.
    @ManyToOne
    @JoinColumn(name = "psychology_test_id")
    private PsychologyTestInfo psychologyTestInfo;

    // 수정된 날짜
    @Timestamp
    private LocalDate updatedDate;

    @Column(nullable = false)
    private Boolean openToPublic;

    @Builder
    public UserPsychologyTestInfoOption(User user, PsychologyTestInfo psychologyTestInfo, boolean openToPublic) {
        this.user = user;
        this.psychologyTestInfo = psychologyTestInfo;
        this.openToPublic = openToPublic;
    }
}
