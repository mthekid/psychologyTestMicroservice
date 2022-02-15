package com.starlab.demo.psychology.dto.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiDTO {
    private String name;
    private String testName;
    private List<QuestionareResultDTO> testResult;
}
