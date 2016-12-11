package clinic.backend.dao;

import clinic.backend.dto.DoctorDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorDAOArrayListImpl implements DoctorDAO{

    private List<DoctorDTO> doctors = new ArrayList<>();

    public DoctorDAOArrayListImpl() {
        doctors.add(new DoctorDTO(1L, "Adrian"));
        doctors.add(new DoctorDTO(2L, "Joanna"));
    }

    @Override
    public List<DoctorDTO> getAll() {
        return doctors;
    }

    @Override
    public void add(DoctorDTO doctor) {
        doctors.add(doctor);
    }
}
