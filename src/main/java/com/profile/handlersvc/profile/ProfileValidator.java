package com.profile.handlersvc.profile;

import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import java.time.LocalDate;

@AllArgsConstructor
@Component
public class ProfileValidator {

    private final ProfileRepo profileRepo;


    public UserProfile validate(MultiValueMap<String, String> formData) {
        String email = formData.getFirst("email");
        UserProfile userProfile =  profileRepo.findByEmail(email).orElseThrow();

        String dob = formData.getFirst("dob");
        Gender gender = Gender.valueOf(formData.getFirst("gender"));
        String description = formData.getFirst("description");
        String bio = formData.getFirst("bio");
        String workAt = formData.getFirst("workAt");

        userProfile.setGender(gender);
        userProfile.setDob(dob);
        userProfile.setDescription(description);
        userProfile.setWorkAt(workAt);
        userProfile.setBio(bio);

        return userProfile;


    }
}
