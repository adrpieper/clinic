package clinic.backend.data;

import clinic.backend.dao.DoctorDAO;
import clinic.backend.dto.DoctorDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;

public class DoctorsFromFileProvider {

    private final DoctorDAO doctorDAO;

    @Autowired
    public DoctorsFromFileProvider(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    public void provide() {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = DoctorsFromFileProvider.class.getResourceAsStream("doctors.json");
        try {
            DoctorDTO[] doctors = mapper.readValue(inputStream, DoctorDTO[].class);
            for (DoctorDTO doctor : doctors) {
                doctorDAO.add(doctor);
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't load doctors from doctors.json", e);
        }
    }
}
