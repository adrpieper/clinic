package clinic.backend.dto;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.Map;

public class DoctorDTO {

    private Long id;
    private String name;
    private String surname;
    private String title;
    private EnumMap<DayOfWeek, ScheduleOfDay> schedule;

    public DoctorDTO() {
    }

    public DoctorDTO(Long id, String name, String surname, String title, EnumMap<DayOfWeek, ScheduleOfDay> schedule) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.schedule = schedule;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname){ this.surname = surname; }
    public String getSurname() { return surname; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setSchedule(EnumMap<DayOfWeek, ScheduleOfDay> schedule) {
        this.schedule = schedule;
    }

    public EnumMap<DayOfWeek, ScheduleOfDay> getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "DoctorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", title='" + title + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}
