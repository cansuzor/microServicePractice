package com.example.cansuzor.tutorial.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name="Candidates")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String jobName;
    private String nickName;

}
