package com.shortner.io;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class URLStorage {
    private final ConcurrentHashMap<String, String> shortCodeToUrlMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, String> urlToShortCodeMap = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);  // Atomic counter for unique IDs

    public void save(UrlEntry entry) {
        shortCodeToUrlMap.put(entry.getShortCode(), entry.getOriginalUrl());
        urlToShortCodeMap.put(entry.getOriginalUrl(), entry.getShortCode());
    }

    public String getUrlByShortCode(String shortCode) {
        return shortCodeToUrlMap.getOrDefault(shortCode, null);
    }

    public String getShortCodeByUrl(String originalUrl) {
        return urlToShortCodeMap.getOrDefault(originalUrl, null);
    }

    public long getNextId() {
        return idCounter.getAndIncrement();  // Increment and return the next ID
    }
}


