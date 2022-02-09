package com.starlab.demo.psychology.model;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(unique = true)
    private String medicalInfo;

    @OneToMany(mappedBy = "user")
    private List<UserPsychologyTestInfoOption> userPsychologyTestInfoOptions = new ArrayList<>();

    @Builder
    public User(String name, String email, String medicalInfo) {
        this.name = name;
        this.email = email;
        this.medicalInfo = medicalInfo;
    }
}
