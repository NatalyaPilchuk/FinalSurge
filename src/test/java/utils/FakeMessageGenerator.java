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

    public static Integer generateWeight() {
        return new Faker().random().nextInt(30, 500);
    }

    public static Integer generateHeight() {
        return new Faker().random().nextInt(1, 86);
    }

    public static Integer generateNumberFromTo() {
        return new Faker().random().nextInt(2, 5);
    }

    public static Integer generateHours() {
        return new Faker().random().nextInt(2, 7);
    }

    public static Integer generateMinutesSeconds() {
        return new Faker().random().nextInt(1, 59);
    }

    public static String generateBrand() {
        return new Faker().name().firstName();
    }

    public static String generateCaloricDistance() {
        return new Faker().numerify("##");
    }

    public static String generateTwoDigitNumber() { return new Faker().numerify("##"); }

    public static Integer generateAge() {
        return new Faker().random().nextInt(5, 99);
    }

    public static String generateZipCode() {
        return new Faker().address().zipCode();
    }
}
