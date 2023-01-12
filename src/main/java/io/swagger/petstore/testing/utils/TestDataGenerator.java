package io.swagger.petstore.testing.utils;

import io.swagger.petstore.testing.models.user.User;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class TestDataGenerator {

    public static User generateFullDataUser() {
        return User.builder()
                .id(getRandomInt())
                .username(getRandomString())
                .firstName(getRandomString())
                .lastName(getRandomString())
                .email(getRandomString() + "@gmail.com")
                .password(getRandomString())
                .phone("+79" + getPhoneNumber())
                .userStatus(getRandomInt()).build();
    }

    private static Integer getRandomInt() {
        return new Random().nextInt((65536) - 32768);
    }

    private static String getRandomString() {
        return RandomStringUtils.randomAlphabetic(7);
    }

    private static String getPhoneNumber() {
        return RandomStringUtils.randomNumeric(9);
    }
}
