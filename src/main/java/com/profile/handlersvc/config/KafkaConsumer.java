//package com.profile.handlersvc.config;
//
//import com.profile.handlersvc.profile.ProfileService;
//import com.profile.handlersvc.profile.UserProfile;
//import com.profile.handlersvc.profilecontroller.ProfileController;
//import lombok.AllArgsConstructor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//
//@Service
//@AllArgsConstructor
//public class KafkaConsumer {
//
//    private final ProfileService profileService;
//    private final Logger logger = LoggerFactory.getLogger(ProfileController.class);
//    @KafkaListener(topics = "test", groupId = "group_id")
//    public void consume(String message) throws IOException {
//        logger.info(String.format("#### -> Consumed message -> %s", message));
//        UserProfile userProfile = profileService.createUserProfile(message);
//
//    }
//}