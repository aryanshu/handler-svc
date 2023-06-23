package com.profile.handlersvc.profile;

import com.profile.handlersvc.profile.UserProfile;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepo extends JpaRepository<UserProfile,Long> {
    Optional<UserProfile> findByEmail(String email);
}
