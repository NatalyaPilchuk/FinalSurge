package utils;

import com.github.javafaker.Faker;

public class FakeMessageGenerator {

    public static String generateBrand() {
        return new Faker().name().title();
    }
    public static String generateDistance(){
        return String.valueOf(new Faker().number().randomNumber());
    }
    public static String generateMoney(){
        return String.valueOf(new Faker().number().randomNumber());
    }
    public static String generateNotes(){
        return new Faker().harryPotter().character();
    }

}
