package com.mapper.io;

public class Main {
    public static void main(String[] args) {
        ShortenUrl shortenUrl = new ShortenUrl();
        String shortendUrl = shortenUrl.shortenUrl("https://developers.googleblog.com/2018/03/transitioning-google-url-shortener.html");
        String originalUrl = shortenUrl.getOriginalUrl(shortendUrl);
        System.out.println("Output: " + shortendUrl + "\n"+originalUrl);
    }
}