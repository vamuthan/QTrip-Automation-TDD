package utils;

import com.github.javafaker.Faker;

public class DataUtility {

    protected static Faker faker;

    public DataUtility() {
        faker = new Faker();
    }

    public String generateFakeEmailId() {
        return faker.internet().emailAddress();
    }

    public String generateFakePassword() {
        return faker.internet().password();
    }
}
