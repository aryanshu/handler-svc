package com.profile.handlersvc.datagenerator;

import com.profile.handlersvc.profile.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DataGenerator {

    private ProfileRepo profileRepo;
    public void Data(){
        UserProfile userProfile = new UserProfile(Long.valueOf(2),"alex@gmail.com","Alex","Hammer","1998-04-19", Gender.Male,"Meet John, a 22-year-old male who works at Google and is passionate about life and adventure. ",
                "I want to know your favorite song, but in order to tell me, you have to sing it to me","Influncer",
                Preferance.Female,"+91 2345678123"," 26.8467° N latitude 80.9462° E longitude",true,200, RelationGoal.FiguringOut, Education.AtUni, StarSign.Cancer,
                Children.No, Vaccinated.Yes, Personality.Extrovert, Pets.Dog,  Smoke.Occasionally, Drink.Yes, Exercise.Moderate
                , Diet.Omnivore, Status.Single, null);
        profileRepo.save(userProfile);

        UserProfile userProfile1 = new UserProfile(Long.valueOf(3), "alex1@gmail.com", "Alex", "Hammer", "1998-04-19", Gender.Male,
                "Meet John, a 22-year-old male who works at Google and is passionate about life and adventure. With a zest for exploration, he loves engaging in various activities that make every moment count. Whether it's hiking through scenic trails, exploring hidden gems in the city, or trying out thrilling water sports, John's adventurous spirit knows no bounds.",
                "I want to know your favorite song, but in order to tell me, you have to sing it to me", "Influencer",
                Preferance.Female, "+91 2345678123", "26.8467° N latitude 80.9462° E longitude", true, 200,
                RelationGoal.FiguringOut, Education.AtUni, StarSign.Cancer, Children.No, Vaccinated.Yes,
                Personality.Extrovert, Pets.Dog, Smoke.Occasionally, Drink.Yes, Exercise.Moderate, Diet.Omnivore,
                Status.Single, null);

        UserProfile userProfile2 = new UserProfile(Long.valueOf(4), "jane@gmail.com", "Jane", "Doe", "1995-08-12", Gender.Female,
                "Jane is a 26-year-old woman with a passion for art and creativity. She enjoys painting, sculpting, and exploring different art forms. Her artistic expression knows no bounds, and she loves to share her creations with others.",
                "I find inspiration in the beauty of nature and the emotions it evokes. Let's create something beautiful together!", "Artist",
                Preferance.Male, "+91 3456789123", "34.0522° N latitude 118.2437° W longitude", false, 150,
                RelationGoal.LongTerm, Education.Masters, StarSign.Leo, Children.No, Vaccinated.Yes,
                Personality.Ambivert, Pets.Cat, Smoke.No, Drink.Yes, Exercise.Moderate, Diet.Vegetarian,
                Status.Single, null);

        UserProfile userProfile3 = new UserProfile(Long.valueOf(5), "mark@gmail.com", "Mark", "Johnson", "1992-12-03", Gender.Male,
                "Meet Mark, a 29-year-old software engineer who loves solving complex problems through coding. He enjoys building innovative software solutions and pushing the boundaries of technology. In his free time, Mark likes to contribute to open-source projects and explore new programming languages.",
                "Let's write beautiful code together and create amazing software that makes a difference!", "Software Engineer",
                Preferance.Everyone, "+91 4567891234", "40.7128° N latitude 74.0060° W longitude", true, 250,
                RelationGoal.ShortTerm, Education.Bachelors, StarSign.Sagittarius, Children.No, Vaccinated.Yes,
                Personality.Introvert, Pets.None, Smoke.No, Drink.Occasionally, Exercise.Active, Diet.Omnivore,
                Status.Single, null);

        UserProfile userProfile4 = new UserProfile(Long.valueOf(6), "alex3@gmail.com", "Alex", "Hammer", "1998-04-19", Gender.Male,
                "Meet John, a 22-year-old male who works at Google and is passionate about life and adventure. With a zest for exploration, he loves engaging in various activities that make every moment count. Whether it's hiking through scenic trails, exploring hidden gems in the city, or trying out thrilling water sports, John's adventurous spirit knows no bounds.",
                "I want to know your favorite song, but in order to tell me, you have to sing it to me", "Influencer",
                Preferance.Female, "+91 2345678123", "26.8467° N latitude 80.9462° E longitude", true, 200,
                RelationGoal.FiguringOut, Education.AtUni, StarSign.Cancer, Children.No, Vaccinated.Yes,
                Personality.Extrovert, Pets.Dog, Smoke.Occasionally, Drink.Yes, Exercise.Moderate, Diet.Omnivore,
                Status.Single, null);

        UserProfile userProfile5 = new UserProfile(Long.valueOf(7), "jane2@gmail.com", "Jane", "Doe", "1995-08-12", Gender.Female,
                "Jane is a 26-year-old woman with a passion for art and creativity. She enjoys painting, sculpting, and exploring different art forms. Her artistic expression knows no bounds, and she loves to share her creations with others.",
                "I find inspiration in the beauty of nature and the emotions it evokes. Let's create something beautiful together!", "Artist",
                Preferance.Male, "+91 3456789123", "34.0522° N latitude 118.2437° W longitude", false, 150,
                RelationGoal.LongTerm, Education.Masters, StarSign.Leo, Children.No, Vaccinated.Yes,
                Personality.Ambivert, Pets.Cat, Smoke.No, Drink.Yes, Exercise.Moderate, Diet.Vegetarian,
                Status.Single, null);

        UserProfile userProfile6 = new UserProfile(Long.valueOf(8), "mark2@gmail.com", "Mark", "Johnson", "1992-12-03", Gender.Male,
                "Meet Mark, a 29-year-old software engineer who loves solving complex problems through coding. He enjoys building innovative software solutions and pushing the boundaries of technology. In his free time, Mark likes to contribute to open-source projects and explore new programming languages.",
                "Let's write beautiful code together and create amazing software that makes a difference!", "Software Engineer",
                Preferance.Everyone, "+91 4567891234", "40.7128° N latitude 74.0060° W longitude", true, 250,
                RelationGoal.ShortTerm, Education.Bachelors, StarSign.Sagittarius, Children.No, Vaccinated.Yes,
                Personality.Introvert, Pets.None, Smoke.No, Drink.Occasionally, Exercise.Active, Diet.Omnivore,
                Status.Single, null);


        profileRepo.save(userProfile1);
        profileRepo.save(userProfile2);
        profileRepo.save(userProfile3);
        profileRepo.save(userProfile4);
        profileRepo.save(userProfile5);
        profileRepo.save(userProfile6);



    }
}
