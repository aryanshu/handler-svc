package com.profile.handlersvc.profile;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;



@Setter
@Getter
@NoArgsConstructor
@Entity
public class UserProfile {

    @SequenceGenerator(
            name = "user_profile_sequence",
            sequenceName = "user_profile_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_profile_sequence"
    )
    @Column(updatable = false)
    private Long id;
    @Column(nullable = false, updatable = false)
    private String email;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column
    private String dob;

    @Transient
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String description;

    private String bio;

    private String workAt;

    public UserProfile(String email, String firstName, String lastName, String dob, Gender gender,
                       String description, String bio, String workAt) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.description = description;
        this.bio = bio;
        this.workAt = workAt;
    }
}
