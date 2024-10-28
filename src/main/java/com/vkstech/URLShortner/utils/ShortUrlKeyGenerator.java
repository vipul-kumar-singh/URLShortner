package com.vkstech.URLShortner.utils;

import java.util.Random;

import static com.vkstech.URLShortner.constant.UrlConstants.MAX_LENGTH;

public class ShortUrlKeyGenerator {

    private static final Random random = new Random();

    public static String getShortUrlKey() {
        // Get the current time in milliseconds
        long currentTimeMillis = System.currentTimeMillis();

        // Convert to base 36 (0-9, a-z)
        String base36 = Long.toString(currentTimeMillis, 36);

        // Generate a random number and convert it to base 36
        String randomPart = Long.toString(random.nextInt(36 * 36), 36);

        // Combine the two parts
        String combined = base36 + randomPart;

        // Ensure the string is exactly the desired length
        if (combined.length() < MAX_LENGTH) {
            // Pad with '0's if it's shorter than the desired length
            combined = String.format("%0" + MAX_LENGTH + "d", Long.parseLong(combined));
        } else if (combined.length() > MAX_LENGTH) {
            // Truncate to the desired length if it's longer
            combined = combined.substring(0, MAX_LENGTH);
        }

        return combined;
    }
}
