package example.micronaut;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micronaut.context.annotation.ConfigurationBuilder;
import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Serdeable
@JsonIgnoreProperties("builder")
@ConfigurationProperties("team")
public class TeamConfiguration {

    private String name;
    private String color;
    private List<String> playerNames;

    public TeamConfiguration() {
    }

    @ConfigurationBuilder(prefixes = "with", configurationPrefix = "team-admin")
    protected TeamAdmin.Builder builder = TeamAdmin.builder();
}

