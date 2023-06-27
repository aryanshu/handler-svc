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


        if(formData.containsKey("description")){
            userProfile.setDescription(formData.getFirst("description"));
        }
        if(formData.containsKey("bio")){
            userProfile.setBio(formData.getFirst("bio"));
        }
        if(formData.containsKey("workAt")){
            userProfile.setWorkAt(formData.getFirst("workAt"));
        }
        if(formData.containsKey("preference")){
            userProfile.setPreferance(Preferance.valueOf(formData.getFirst("preference")));
        }
        if(formData.containsKey("phoneNumber")){
            userProfile.setPhoneNumber(formData.getFirst("phoneNumber"));
        }
        if(formData.containsKey("location")){
            userProfile.setLocation(formData.getFirst("location"));
        }
        if(formData.containsKey("global")){
            userProfile.setGlobal(Boolean.parseBoolean(formData.getFirst("global")));
        }
        if(formData.containsKey("maximumDistance")){
            userProfile.setMaximumDistance(Integer.valueOf(formData.getFirst("maximumDistance")));
        }
        if (formData.containsKey("sleeping")) {
            userProfile.setSleeping(Sleeping.valueOf(formData.getFirst("sleeping")));
        }
        if (formData.containsKey("status")) {
            userProfile.setStatus(Status.valueOf(formData.getFirst("status")));
        }
        if (formData.containsKey("diet")) {
            userProfile.setDiet(Diet.valueOf(formData.getFirst("diet")));
        }
        if (formData.containsKey("exercise")) {
            userProfile.setExercise(Exercise.valueOf(formData.getFirst("exercise")));
        }
        if (formData.containsKey("drink")) {
            userProfile.setDrink(Drink.valueOf(formData.getFirst("drink")));
        }
        if (formData.containsKey("smoke")) {
            userProfile.setSmoke(Smoke.valueOf(formData.getFirst("smoke")));
        }
        if (formData.containsKey("pets")) {
            userProfile.setPets(Pets.valueOf(formData.getFirst("pets")));
        }
        if (formData.containsKey("personality")) {
            userProfile.setPersonality(Personality.valueOf(formData.getFirst("personality")));
        }
        if (formData.containsKey("vaccinated")) {
            userProfile.setVaccinated(Vaccinated.valueOf(formData.getFirst("vaccinated")));
        }
        if (formData.containsKey("children")) {
            userProfile.setChildren(Children.valueOf(formData.getFirst("children")));
        }
        if (formData.containsKey("starSign")) {
            userProfile.setStarSign(StarSign.valueOf(formData.getFirst("starSign")));
        }
        if (formData.containsKey("education")) {
            userProfile.setEducation(Education.valueOf(formData.getFirst("education")));
        }

        if (formData.containsKey("lowerRange")) {
            userProfile.setLowerRange(Integer.valueOf(formData.getFirst("lowerRange")));
        }

        if (formData.containsKey("higherRange")) {
            userProfile.setHigherRange(Integer.valueOf(formData.getFirst("higherRange")));
        }



        userProfile.setGender(gender);
        userProfile.setDob(dob);


        return userProfile;


    }
}
