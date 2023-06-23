package com.profile.handlersvc.profile;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class UserSettings {

    @Id
    private Long id;
    private Integer lowerRange;
    private Integer higherRange;

    @Enumerated(EnumType.STRING)
    private Preferance preferance;

    private Long phoneNumber;

    private String location;

    boolean global;
    Integer maximumDistance;




}
