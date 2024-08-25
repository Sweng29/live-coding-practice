package com.mapper.io;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ShortenUrl {
    private Map<String, String> shortenedUrls;

    public ShortenUrl(){
        this.shortenedUrls = new ConcurrentHashMap<>();
    }

    public String shortenUrl(String url){
        String id = "https://bit.ly/" + Base64.getUrlEncoder().encodeToString(url.getBytes(StandardCharsets.UTF_8))
                .substring(0,5);
        shortenedUrls.put(id, url);
        return id;
    }

    public String getOriginalUrl(String id){
        if (!shortenedUrls.containsKey(id))
            throw new IllegalArgumentException("Invalid id provided");
        return shortenedUrls.get(id);
    }

    public Map<String, String> getShortenedUrls() {
        return shortenedUrls;
    }

    public void setShortenedUrls(Map<String, String> shortenedUrls) {
        this.shortenedUrls = shortenedUrls;
    }
}
