package com.stb.utils;

import java.util.UUID;

public class TestDataGenerator {
    // Generate a random email
    public static String generateRandomEmail() {
        return "user" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";
    }

    // Generate a random password
    public static String generateRandomPassword() {
        return "Pass@" + UUID.randomUUID().toString().substring(0, 8);
    }

    // Generate a random first name
    public static String generateRandomFirstName() {
        return "FirstName" + UUID.randomUUID().toString().substring(0, 5);
    }

    // Generate a random last name
    public static String generateRandomLastName() {
        return "LastName" + UUID.randomUUID().toString().substring(0, 5);
    }
}
