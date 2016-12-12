package clinic.backend.dto;

public class DoctorDTO {

    private Long id;
    private String name;
    private String surname;
    private String title;

    public DoctorDTO() {
    }

    public DoctorDTO(Long id, String name, String surname, String title) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.title = title;
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
}
