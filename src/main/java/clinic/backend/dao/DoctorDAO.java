package clinic.backend.dao;

import clinic.backend.dto.DoctorDTO;

import java.util.List;

public interface DoctorDAO {
    List<DoctorDTO> getAll();
    void add(DoctorDTO doctor);
    DoctorDTO getById(long id);
    void deleteDoctorById(long id);

}
