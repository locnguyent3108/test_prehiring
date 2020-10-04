package helper;

import com.github.javafaker.Faker;

public class FakeData {
    public static Faker testData = new Faker();

    public static String getEmail() {
        return testData.internet().safeEmailAddress();
    }

    public static String getName() {
        return testData.name().firstName();
    }

    public static String getPassword() {
        return testData.internet().password();
    }
}

