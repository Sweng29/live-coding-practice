package com.shortner.io;
public class URLShortener {
    private final Base62Encoder encoder;
    private final URLStorage storage;

    private static final Long URL_LENGTH = 6L;

    public URLShortener() {
        this.encoder = new Base62Encoder();
        this.storage = new URLStorage();
    }

    public String shorten(String originalUrl) {
        // Check if the original URL has already been shortened
        String existingShortCode = storage.getShortCodeByUrl(originalUrl);
        if (existingShortCode != null) {
            return existingShortCode;
        }

        // Generate a new short code for the URL
//        long id = storage.getNextId();
        String shortCode = encoder.encode(URL_LENGTH);

        // Store the mapping between short code and original URL
        UrlEntry entry = new UrlEntry(shortCode, originalUrl);
        storage.save(entry);

        return shortCode;
    }

    public String getOriginalUrl(String shortCode) {
        return storage.getUrlByShortCode(shortCode);
    }
}


