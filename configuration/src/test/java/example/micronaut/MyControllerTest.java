package example.micronaut;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Oywayten 15.01.2024.
 */

@MicronautTest
public class MyControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void testMyTeam() {
        TeamConfiguration teamConfiguration = client.toBlocking()
                .retrieve(HttpRequest.GET("/my/team"), TeamConfiguration.class);
        assertEquals("Steelers", teamConfiguration.getName());
        assertEquals("Black", teamConfiguration.getColor());
        List<String> expectedPlayers = Arrays.asList("Mason Rudolph", "James Connor");
        assertEquals(expectedPlayers.size(), teamConfiguration.getPlayerNames().size());
        assertEquals(expectedPlayers, teamConfiguration.getPlayerNames());
    }

    @Test
    void testMyStadium() {
        StadiumConfiguration conf = client.toBlocking()
                .retrieve(HttpRequest.GET("/my/stadium"), StadiumConfiguration.class);
        assertEquals("Pittsburgh", conf.getCity());
        assertEquals(35000, conf.getSize());
    }
}
