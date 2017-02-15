package clinic.backend.dao;

import clinic.backend.dto.DoctorDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DoctorDAOHashMapImpl implements DoctorDAO{

    private Map<Long,DoctorDTO> doctors = new HashMap<>();

    @Override
    public List<DoctorDTO> getAll() {
        return new ArrayList<>(doctors.values());
    }

    @Override
    public void add(DoctorDTO doctor) {
        doctors.put(doctor.getId(), doctor);
    }

    @Override
    public DoctorDTO getById(long id) {
        return doctors.get(id);
    }

    public void deleteDoctorById(long id) { doctors.remove(id); }

}
