package com.shortner.io;
public class UrlShortenerMain {
    public static void main(String[] args){
        URLShortener urlShortener = new URLShortener();
        String originalUrl = "https://example.com";
        String shortenCode = urlShortener.shorten(originalUrl);
        String originalUrlResponse = urlShortener.getOriginalUrl(shortenCode);
        System.out.println(originalUrl + " "+ originalUrlResponse + " "+ shortenCode);
    }
}