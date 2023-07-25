package com.profile.handlersvc.profile;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.profile.handlersvc.appuser.AppUser;
import com.profile.handlersvc.appuser.AppUserRepository;
import com.profile.handlersvc.config.Constants;
import com.profile.handlersvc.config.KafkaProducer;
import com.profile.handlersvc.profile.ProfileRepo;
import com.profile.handlersvc.profile.UserProfile;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Slf4j
@AllArgsConstructor
public class ProfileService {

    private final ProfileRepo profileRepo;

    private final AppUserRepository appUserRepository;

    private final KafkaProducer kafkaProducer;

    @Transactional
    public void handleProfileRequest(UserProfile userProfile) {
        try {
            profileRepo.save(userProfile);
            log.info("Profile Saved successfully");
        } catch (Exception e) {
            log.error("Error is occurred ",e.toString());
            throw new RuntimeException("Error is occurred while saving profile into database");
        }

        try {
            pushKafka(userProfile);
            log.info("Successfully pushed kafka payload");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    private void pushKafka(UserProfile userProfile) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer();

        String json = objectWriter.writeValueAsString(userProfile);
        kafkaProducer.sendMessage(json, Constants.topic);
    }

    public UserProfile createUserProfile(String email) {
        AppUser appUser=appUserRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User not found"));
        UserProfile userProfile = new UserProfile(appUser.getId(),appUser.getEmail(), appUser.getFirstName(),
                appUser.getLastName(), "",null,"","","",null,null,"",false,null);
        profileRepo.save(userProfile);
        return userProfile;
    }

    public UserProfile getProfile(Long Id) {
        return profileRepo.findById(Id).orElseThrow(()->new RuntimeException("User not found"));
    }


}
