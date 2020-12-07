package ua.com.foxminded.java8api.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Racer {
    private final String racerName;
    private final String teamName;
    private final LocalDateTime startRace;
    private final LocalDateTime endRace;

    private Racer(Builder builder) {
        this.racerName = builder.racerName;
        this.teamName = builder.teamName;
        this.startRace = builder.startRace;
        this.endRace = builder.endRace;
    }

    public String getRacerName() {
        return racerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public LocalDateTime getStartRace() {
        return startRace;
    }

    public LocalDateTime getEndRace() {
        return endRace;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String racerName;
        private String teamName;
        private LocalDateTime startRace;
        private LocalDateTime endRace;

        private Builder() {
        }

        public Racer build() {
            return new Racer(this);
        }

        public Builder withRacerName(String racerName) {
            this.racerName = racerName;
            return this;
        }

        public Builder withTeamName(String teamName) {
            this.teamName = teamName;
            return this;
        }

        public Builder withStartRace(LocalDateTime startRace) {
            this.startRace = startRace;
            return this;
        }

        public Builder withEndRace(LocalDateTime endRace) {
            this.endRace = endRace;
            return this;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Racer racer = (Racer) o;

        return Objects.equals(racerName, racer.racerName) &&
                Objects.equals(teamName, racer.teamName) &&
                Objects.equals(startRace, racer.startRace) &&
                Objects.equals(endRace, racer.endRace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racerName, teamName, startRace, endRace);
    }

    @Override
    public String toString() {
        return "Racer{" +
                "racerName='" + racerName + '\'' +
                ", teamName='" + teamName + '\'' +
                ", startRace=" + startRace +
                ", endRace=" + endRace +
                '}';
    }
}
