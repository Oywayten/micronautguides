package example.micronaut;

import lombok.Getter;
import lombok.Setter;

/**
 * Oywayten 14.01.2024.
 */

@Getter
@Setter
public class TeamAdmin {

    private String manager;
    private String coach;
    private String president;

    // should use the builder pattern to create the object
    private TeamAdmin() {
    }

    public static Builder builder() {
        return new Builder();
    }

    @Getter
    public static class Builder {
        private String manager;
        private String coach;
        private String president;


        public Builder withManager(String manager) {
            this.manager = manager;
            return this;
        }

        public Builder withCoach(String coach) {
            this.coach = coach;
            return this;
        }

        public Builder withPresident(String president) {
            this.president = president;
            return this;
        }

        public TeamAdmin build() {
            TeamAdmin teamAdmin = new TeamAdmin();
            teamAdmin.manager = this.manager;
            teamAdmin.coach = this.coach;
            teamAdmin.president = this.president;
            return teamAdmin;
        }
    }
}
