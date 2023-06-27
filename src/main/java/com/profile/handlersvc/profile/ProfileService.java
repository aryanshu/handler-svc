package com.profile.handlersvc.profile;


import com.profile.handlersvc.appuser.AppUser;
import com.profile.handlersvc.appuser.AppUserRepository;
import com.profile.handlersvc.profile.ProfileRepo;
import com.profile.handlersvc.profile.UserProfile;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class ProfileService {

    private final ProfileRepo profileRepo;

    private final AppUserRepository appUserRepository;

    public String handleProfileRequest(UserProfile userProfile) {
        profileRepo.save(userProfile);
        return "Profile Saved";
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
