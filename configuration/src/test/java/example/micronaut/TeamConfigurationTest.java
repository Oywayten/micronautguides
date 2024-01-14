package example.micronaut;

import io.micronaut.context.ApplicationContext;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Oywayten 14.01.2024.
 */

class TeamConfigurationTest {

    @Test
    void testTeamConfiguration() {
        List<String> names = Arrays.asList("Nirav Assar", "Lionel Messi");
        Map<String, Object> items = new HashMap<>();
        items.put("team.name", "evolution");
        items.put("team.color", "green");
        items.put("team.player-names", names);
        ApplicationContext ctx = ApplicationContext.run(items);
        TeamConfiguration teamConfiguration = ctx.getBean(TeamConfiguration.class);
        assertEquals("evolution", teamConfiguration.getName());
        assertEquals("green", teamConfiguration.getColor());
        assertEquals(names.size(), teamConfiguration.getPlayerNames().size());
        names.forEach(name -> assertTrue(teamConfiguration.getPlayerNames().contains(name)));
        assertEquals(names, teamConfiguration.getPlayerNames());
        ctx.close();
    }

    @Test
    void testTeamConfigurationBuilder() {
        List<String> names = Arrays.asList("Nirav Assar", "Lionel Messi");
        Map<String, Object> items = new HashMap<>();
        items.put("team.name", "evolution");
        items.put("team.color", "green");
        items.put("team.team-admin.manager", "Jerry Jones");
        items.put("team.team-admin.coach", "Tommy O'Neill");
        items.put("team.team-admin.president", "Mark Scanell");
        items.put("team.player-names", names);
        ApplicationContext ctx = ApplicationContext.run(items);
        TeamConfiguration teamConfiguration = ctx.getBean(TeamConfiguration.class);
        TeamAdmin teamAdmin = teamConfiguration.builder.build();
        assertEquals("evolution", teamConfiguration.getName());
        assertEquals("green", teamConfiguration.getColor());
        assertEquals("Nirav Assar", teamConfiguration.getPlayerNames().get(0));
        assertEquals("Lionel Messi", teamConfiguration.getPlayerNames().get(1));
        assertEquals("Jerry Jones", teamConfiguration.builder.getManager());
        assertEquals("Tommy O'Neill", teamConfiguration.builder.getCoach());
        assertEquals("Mark Scanell", teamConfiguration.builder.getPresident());
        assertEquals("Jerry Jones", teamAdmin.getManager());
        assertEquals("Tommy O'Neill", teamAdmin.getCoach());
        assertEquals("Mark Scanell", teamAdmin.getPresident());
        ctx.close();
    }
}
