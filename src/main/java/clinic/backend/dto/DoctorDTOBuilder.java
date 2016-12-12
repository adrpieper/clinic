package clinic.backend.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.EnumMap;

public class DoctorDTOBuilder {
    private Long id;
    private String name;
    private String surname;
    private String title;
    private EnumMap<DayOfWeek, ScheduleOfDay> schedule = new EnumMap<>(DayOfWeek.class);

    public DoctorDTOBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public DoctorDTOBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public DoctorDTOBuilder withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public DoctorDTOBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public DoctorDTOBuilder withSchedule(EnumMap<DayOfWeek, ScheduleOfDay> schedule) {
        this.schedule = schedule;
        return this;
    }

    public DoctorDTOBuilder withScheduleOfDay(DayOfWeek dayOfWeek, int startHour, int startMin, int endHour, int endMin) {
        this.schedule.put(dayOfWeek, new ScheduleOfDay(LocalTime.of(startHour,startMin), LocalTime.of(endHour,endMin)));
        return this;
    }

    public DoctorDTO createDoctorDTO() {
        return new DoctorDTO(id, name, surname, title, schedule);
    }
}