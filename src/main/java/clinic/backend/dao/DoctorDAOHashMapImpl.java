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
    private long id = 1L;

    @Override
    public List<DoctorDTO> getAll() {
        return new ArrayList<>(doctors.values());
    }

    @Override
    public void save(DoctorDTO doctor) {
        if (doctor.getId() == null){
            doctor.setId(id);
            doctors.put(doctor.getId(), doctor);
            id++;
        }else {
            if (doctors.containsKey(doctor.getId())) {
                doctors.put(doctor.getId(), doctor);
            }
        }
    }

    @Override
    public DoctorDTO getById(long id) {
        return doctors.get(id);
    }

    @Override
    public void deleteDoctorById(long id) { doctors.remove(id); }

}
