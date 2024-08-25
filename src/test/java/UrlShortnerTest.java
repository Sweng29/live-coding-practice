import com.shortner.io.URLShortener;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UrlShortnerTest {
    @Test
    public void givenSameUrl_whenShortenedTwice_thenShouldReturnSameShortUrl() {
        URLShortener shortener = new URLShortener();
        String originalUrl = "https://example.com";

        String shortUrl1 = shortener.shorten(originalUrl);
        String shortUrl2 = shortener.shorten(originalUrl);

        assertEquals(shortUrl1, shortUrl2);  // The same URL should always return the same short code
    }

    @Test
    public void givenDifferentUrls_whenShortened_thenShouldReturnDifferentShortUrls() {
        URLShortener shortener = new URLShortener();
        String originalUrl1 = "https://example1.com";
        String originalUrl2 = "https://example2.com";

        String shortUrl1 = shortener.shorten(originalUrl1);
        String shortUrl2 = shortener.shorten(originalUrl2);

        assertNotEquals(shortUrl1, shortUrl2);  // Different URLs should generate different short codes
    }

}
