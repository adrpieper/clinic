package clinic.backend.dao;

import clinic.backend.dto.DoctorDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorDAOArrayListImpl implements DoctorDAO{

    private List<DoctorDTO> doctors = new ArrayList<>();

    @Override
    public List<DoctorDTO> getAll() {
        return doctors;
    }

    @Override
    public void add(DoctorDTO doctor) {
        doctors.add(doctor);
    }
}
