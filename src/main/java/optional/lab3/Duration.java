package optional.lab3;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Duration {
    private long duration;
    private LocalTime openingTime, closingTime;

    public Duration() {
        this.duration = ChronoUnit.HOURS.between(getOpeningTime(), getClosingTime());
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }
}
