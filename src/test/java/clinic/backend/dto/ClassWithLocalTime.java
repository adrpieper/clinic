package clinic.backend.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalTime;

class ClassWithLocalTime {
    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime time;

    public ClassWithLocalTime() {
    }

    public ClassWithLocalTime(LocalTime time) {
        this.time = time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getTime() {
        return time;
    }

    public static ClassWithLocalTime withTime(int hour, int minute) {
        return new ClassWithLocalTime(LocalTime.of(hour, minute));
    }
}
