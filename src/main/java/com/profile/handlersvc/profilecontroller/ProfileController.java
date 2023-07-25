package com.profile.handlersvc.profilecontroller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.profile.handlersvc.datagenerator.DataGenerator;
import com.profile.handlersvc.profile.*;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/profile")
@AllArgsConstructor
public class ProfileController {

    private final ProfileService profileService;
    private final ProfileValidator profileValidator;

    private final UserInterestRepo userInterestRepo;

    private final DataGenerator dataGenerator;

    private static Logger logger = LoggerFactory.getLogger(ProfileController.class);
    @PostMapping
    ResponseEntity<UserProfile> postDetails(@RequestBody MultiValueMap<String, String> formData){

        UserProfile userProfile = profileValidator.validate(formData);
        logger.debug(String.format("{user: }",userProfile.getEmail()));

        profileService.handleProfileRequest(userProfile);
        return new ResponseEntity<>(userProfile, HttpStatus.OK);

    }

    @GetMapping
    ResponseEntity<UserProfile> getDetails(@RequestParam(required = true) Long Id){
        UserProfile userProfile = profileService.getProfile(Id);
//        dataGenerator.Data();
        return new ResponseEntity<>(userProfile, HttpStatus.OK);

    }

    @PostMapping("/userInterests")
    ResponseEntity<UserInterests> postUserInterestDetails(@RequestBody UserInterests userInterests){
        // Adding temp code for saving profile
        userInterestRepo.save(userInterests);
        return new ResponseEntity<>(userInterests, HttpStatus.OK);

    }



}
