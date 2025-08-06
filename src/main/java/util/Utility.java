package util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Utility {
    public static String generateRandomName() {
        Random random = new Random();
        int length = 20 + random.nextInt(11); // Random length between 20 and 30
        StringBuilder name = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            char letter = (char) ('A' + random.nextInt(26)); // A-Z
            name.append(letter);
        }

        return name.toString();
    }


    public static String generateRandomGmail() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder emailLocalPart = new StringBuilder();
        Random random = new Random();
        int length = 10 + random.nextInt(6); // Length between 10–15

        for (int i = 0; i < length; i++) {
            emailLocalPart.append(characters.charAt(random.nextInt(characters.length())));
        }

        return emailLocalPart.toString() + "@gmail.com";
    }

    public static String generateComplexPassword(int length) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String special = "!@#$%^&*()-_=+<>?";

        String allChars = upper + lower + digits + special;

        SecureRandom random = new SecureRandom();
        List<Character> password = new ArrayList<>();

        // Ensure at least one character from each category
        password.add(upper.charAt(random.nextInt(upper.length())));
        password.add(lower.charAt(random.nextInt(lower.length())));
        password.add(digits.charAt(random.nextInt(digits.length())));
        password.add(special.charAt(random.nextInt(special.length())));

        // Fill remaining characters randomly
        for (int i = 4; i < length; i++) {
            password.add(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Shuffle to avoid predictable pattern
        Collections.shuffle(password);

        // Convert to string
        StringBuilder finalPassword = new StringBuilder();
        for (char c : password) {
            finalPassword.append(c);
        }

        return finalPassword.toString();
    }


    public static String generatePhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder();

        phoneNumber.append(random.nextInt(9) + 1); // Ensure the first digit is non-zero

        for (int i = 0; i < 10; i++) {
            phoneNumber.append(random.nextInt(11));
        }

        return phoneNumber.toString(); // e.g., "9234567890"
    }

    public static String getRandomCategory() {
        Random random = new Random();
        StringBuilder category = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            category.append(random.nextInt(3));
        }

        return category.toString(); // e.g., "9234567890"
    }

    public static String getRandomSubCategory() {
        Random random = new Random();
        StringBuilder category = new StringBuilder();

        for (int i = 0; i < 7; i++) {
            category.append(random.nextInt(8));
        }

        return category.toString(); // e.g., "9234567890"
    }

    public static String getRandomCurrency() {
        Random random = new Random();
        StringBuilder category = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            category.append(random.nextInt(3));
        }

        return category.toString(); // e.g., "9234567890"
    }

    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(3) + 1; // returns 1, 2, or 3
    }

}

