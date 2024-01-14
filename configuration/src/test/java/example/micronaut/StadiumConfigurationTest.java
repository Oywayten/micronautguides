package example.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.inject.qualifiers.Qualifiers;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Oywayten 14.01.2024.
 */

class StadiumConfigurationTest {
    @Test
    void testStadiumConfiguration() {
        Map<String, Object> items = new HashMap<>();
        items.put("stadium.fenway.city", "Boston");
        items.put("stadium.fenway.size", 60000);
        items.put("stadium.wrigley.city", "Chicago");
        items.put("stadium.wrigley.size", 45000);
        items.put("stadium.my.city", "SPb");
        items.put("stadium.my.size", "2000");
        ApplicationContext ctx = ApplicationContext.run(items);
        StadiumConfiguration fenwayConfiguration = ctx.getBean(StadiumConfiguration.class, Qualifiers.byName("fenway"));
        StadiumConfiguration wrigleyConfiguration = ctx.getBean(StadiumConfiguration.class, Qualifiers.byName("wrigley"));
        StadiumConfiguration spbConfiguration = ctx.getBean(StadiumConfiguration.class, Qualifiers.byName("my"));
        assertEquals("fenway", fenwayConfiguration.getName());
        assertEquals(60000, fenwayConfiguration.getSize());
        assertEquals("wrigley", wrigleyConfiguration.getName());
        assertEquals(45000, wrigleyConfiguration.getSize());
        assertEquals("my", spbConfiguration.getName());
        assertEquals(2000, spbConfiguration.getSize());
        assertEquals("SPb", spbConfiguration.getCity());
        ctx.close();
    }
}
