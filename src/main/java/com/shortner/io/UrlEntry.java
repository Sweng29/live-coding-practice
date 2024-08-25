package com.shortner.io;
public class UrlEntry {
    private final String shortCode;
    private final String originalUrl;

    public UrlEntry(String shortCode, String originalUrl) {
        this.shortCode = shortCode;
        this.originalUrl = originalUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }
}
