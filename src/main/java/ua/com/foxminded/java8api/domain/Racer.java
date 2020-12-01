package ua.com.foxminded.java8api.domain;

import java.util.Calendar;

public class Racer {
    private final String racerName;
    private final String teamName;
    private Calendar startRace;
    private Calendar endRace;

    public Racer(Builder builder) {
        this.racerName = builder.racerName;
        this.teamName = builder.teamName;
    }

    public String getRacerName() {
        return racerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public Calendar getStartRace() {
        return startRace;
    }

    public Calendar getEndRace() {
        return endRace;
    }

    public void setStartRace(Calendar startRace) {
        this.startRace = startRace;
    }

    public void setEndRace(Calendar endRace) {
        this.endRace = endRace;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String racerName;
        private String teamName;

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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Racer racer = (Racer) o;

        if (racerName != null ? !racerName.equals(racer.racerName) : racer.racerName != null) {
            return false;
        }
        if (teamName != null ? !teamName.equals(racer.teamName) : racer.teamName != null) {
            return false;
        }
        if (startRace != null ? !startRace.equals(racer.startRace) : racer.startRace != null) {
            return false;
        }

        return endRace != null ? endRace.equals(racer.endRace) : racer.endRace == null;
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
