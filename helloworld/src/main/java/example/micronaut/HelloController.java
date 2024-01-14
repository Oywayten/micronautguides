package example.micronaut;

import io.micronaut.http.annotation.*;

@Controller("/hello")
public class HelloController {

    @Get(produces="text/plain")
    public String index() {
        return "Hello World!";
    }
}
