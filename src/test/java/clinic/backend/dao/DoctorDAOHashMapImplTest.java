package clinic.backend.dao;

import clinic.backend.dto.DoctorDTO;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

/**
 * Created by pjoanna on 12.12.16.
 */
public class DoctorDAOHashMapImplTest {

    DoctorDAOHashMapImpl doctorDAOHashMap = new DoctorDAOHashMapImpl();
    DoctorDTO doctorDTO = new DoctorDTO();
    DoctorDTO doctorDTO1 = new DoctorDTO();


    @Test
    public void getAllAndAddTestAndDelete() throws Exception {

        Assertions.assertThat(doctorDAOHashMap.getAll()).isEmpty();
        doctorDTO.setId(1L);
        doctorDAOHashMap.save(doctorDTO);
        doctorDTO1.setId(2L);
        doctorDAOHashMap.save(doctorDTO1);
        List doctors = doctorDAOHashMap.getAll();
        Assertions.assertThat(doctors).containsExactly(doctorDTO, doctorDTO1);
        doctorDAOHashMap.deleteDoctorById(1L);
        doctors = doctorDAOHashMap.getAll();

        Assertions.assertThat(doctors).containsExactly(doctorDTO1);

    }

    @Test
    public void getById() throws Exception {

        doctorDTO.setId(1L);
        doctorDTO.setName("Simon");
        doctorDTO.setSurname("Audi");
        doctorDTO.setTitle("doc");
        doctorDAOHashMap.save(doctorDTO);
        assert doctorDAOHashMap.getById(1).equals(doctorDTO);
        Assertions.assertThat(doctorDAOHashMap.getById(1)).isEqualTo(doctorDTO);
        Assertions.assertThat(doctorDAOHashMap.getById(2)).isNull();


    }

}