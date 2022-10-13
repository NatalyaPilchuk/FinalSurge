package utils;

import com.github.javafaker.Faker;


public class FakeMessageGenerator {
    public static String generateFirstName() {
        return new Faker().name().firstName();
    }

    public static String generateLastName() {
        return new Faker().name().firstName();
    }

    public static String generatePassword() {
        return new Faker().numerify("######");
    }

    public static String generateDescription() {
        return new Faker().harryPotter().book();
    }

    public static String generateCity() {
        return new Faker().address().city();
    }

    public static String generateEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String generateWeight() {
        return new Faker().numerify("##");
    }

    public static Integer generateNumberFromTo() {
        return new Faker().random().nextInt(2, 5);
    }

    public static String generateBrand() {

        return new Faker().name().firstName();
    }

    public static String generateDistance() {
        return String.valueOf(new Faker().number().randomNumber());
    }

    public static String generateCaloricDistance() {
        return new Faker().numerify("##");
    }

    public static String generateMoney() {
        return String.valueOf(new Faker().number().randomNumber());
    }

    public static String generateNotes() {
        return new Faker().harryPotter().character();
    }

    public static String generateZipCode() {
        return new Faker().address().zipCode();
    }
}
