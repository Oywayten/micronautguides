package example.micronaut;

import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

/**
 * Oywayten 14.01.2024.
 */

@Serdeable
@EachProperty("stadium")
@Getter
@Setter
public class StadiumConfiguration {

    private String name;
    private String city;
    private Integer size;

    public StadiumConfiguration(@Parameter String name) {
        this.name = name;
    }
}
