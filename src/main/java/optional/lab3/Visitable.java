package optional.lab3;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public interface Visitable  {
    default LocalTime getStartHour() {
        return LocalTime.of(9,30);
    }

    default LocalTime getFinishHour() {
        return LocalTime.of(20, 00);
    }

    static Duration getVisitingDuration() {
        return new Duration();
    }

    public class Duration implements Visitable {
        private long duration;

        public Duration() {
            this.duration = ChronoUnit.HOURS.between(getStartHour(), getFinishHour());
        }

        public long getDuration() {
            return duration;
        }

        public void setDuration(long duration) {
            this.duration = duration;
        }
    }
}
