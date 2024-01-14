package example.micronaut;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.micronaut.context.annotation.ConfigurationBuilder;
import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;

import java.util.List;

@Getter
@Serdeable
@JsonIgnoreProperties("builder")
//tag::teamConfigClassNoBuilder[]
@ConfigurationProperties("team")
public class TeamConfiguration {
    //tag::gettersandsetters[]
    private String name;
    private String color;
    private List<String> playerNames;
//end::teamConfigClassNoBuilder[]

    public TeamConfiguration() {
    }

    @ConfigurationBuilder(prefixes = "with", configurationPrefix = "team-admin")
    protected TeamAdmin.Builder builder = TeamAdmin.builder();

    public void setBuilder(TeamAdmin.Builder builder) {
        this.builder = builder;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPlayerNames(List<String> playerNames) {
        this.playerNames = playerNames;
    }
}
//end::gettersandsetters[]
