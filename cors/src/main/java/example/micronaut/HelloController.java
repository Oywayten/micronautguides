package example.micronaut;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

/**
 * Oywayten 15.01.2024.
 */

@Controller
public class HelloController {

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        return "Hello World";
    }
}
