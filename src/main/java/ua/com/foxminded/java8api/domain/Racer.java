package ua.com.foxminded.java8api.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Racer {
    private final String racerName;
    private final String teamName;
    private final LocalDateTime startRace;
    private final LocalDateTime endRace;

    public Racer(Builder builder) {
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

        if (!Objects.equals(racerName, racer.racerName)) return false;
        if (!Objects.equals(teamName, racer.teamName)) return false;
        if (!Objects.equals(startRace, racer.startRace)) return false;
        return Objects.equals(endRace, racer.endRace);
    }

    @Override
    public int hashCode() {
        int result = racerName != null ? racerName.hashCode() : 0;
        result = 31 * result + (teamName != null ? teamName.hashCode() : 0);
        result = 31 * result + (startRace != null ? startRace.hashCode() : 0);
        result = 31 * result + (endRace != null ? endRace.hashCode() : 0);
        return result;
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
