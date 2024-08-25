package com.shortner.io;

import java.util.Random;

public class Base62Encoder {
    private static final String BASE_62_ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Random random = new Random();

    public String encode(long length) {
        if (length < 1) throw new IllegalArgumentException("Length must be greater than 0");
        StringBuilder link = new StringBuilder();
        for (int i = 0; i < length; i++) {
            link.append(BASE_62_ALPHABET.charAt(random.nextInt(BASE_62_ALPHABET.length())));
        }
        return link.toString();
    }
}
