package com.profile.handlersvc.profilecontroller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.profile.handlersvc.profile.ProfileService;
import com.profile.handlersvc.profile.ProfileValidator;
import com.profile.handlersvc.profile.UserProfile;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profile")
@AllArgsConstructor
public class ProfileController {

    private final ProfileService profileService;
    private final ProfileValidator profileValidator;
    private static Logger logger = LoggerFactory.getLogger(ProfileController.class);
    @PostMapping("/")
    ResponseEntity<UserProfile> postDetails(@RequestBody MultiValueMap<String, String> formData){
        // Adding temp code for saving profile
        UserProfile userProfile1 = profileService.createUserProfile(formData.getFirst("email"));

        UserProfile userProfile = profileValidator.validate(formData);
        logger.debug(String.format("{user: }",userProfile.getEmail()));

        String message = profileService.handleProfileRequest(userProfile);
        return new ResponseEntity<>(userProfile, HttpStatus.OK);

    }

    @GetMapping("/")
    ResponseEntity<UserProfile> getDetails(@RequestParam(required = true) String email){
        UserProfile userProfile = profileService.getProfile(email);

        // Converting custom object to JSON
//        ObjectMapper objectMapper = new ObjectMapper();
//        String response=null;
//        try {
//            response = objectMapper.writeValueAsString(userProfile);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return new ResponseEntity<>(userProfile, HttpStatus.OK);

    }
}
