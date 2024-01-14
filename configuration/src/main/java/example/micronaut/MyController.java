package example.micronaut;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import jakarta.inject.Named;

/**
 * Oywayten 15.01.2024.
 */

@Controller("/my")
public class MyController {

    private final TeamConfiguration teamConfiguration;
    private final StadiumConfiguration stadiumConfiguration;

    public MyController(@Nullable TeamConfiguration teamConfiguration,
                        @Nullable @Named("pnc") StadiumConfiguration stadiumConfiguration) {
        this.teamConfiguration = teamConfiguration;
        this.stadiumConfiguration = stadiumConfiguration;
    }

    @Get("/team")
    public TeamConfiguration team() {
        return this.teamConfiguration;
    }

    @Get("/stadium")
    public  StadiumConfiguration stadium() {
        return this.stadiumConfiguration;
    }
}
