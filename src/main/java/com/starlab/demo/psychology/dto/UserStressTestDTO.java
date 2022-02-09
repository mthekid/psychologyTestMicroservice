package com.starlab.demo.psychology.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 지각된 스트레스 척도(PSS)에 대한 사용자 입력값이다.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserStressTestDTO {

    private String name;
    private String email;
    private String version;

    private int q1;
    private int q2;
    private int q3;
    private int q4;
    private int q5;
    private int q6;
    private int q7;
    private int q8;
    private int q9;
    private int q10;
}
