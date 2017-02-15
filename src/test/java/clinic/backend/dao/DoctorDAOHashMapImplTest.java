package clinic.backend.dao;

import clinic.backend.dto.DoctorDTO;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by pjoanna on 12.12.16.
 */
public class DoctorDAOHashMapImplTest {

    DoctorDAOHashMapImpl doctorDAOHashMap = new DoctorDAOHashMapImpl();
    DoctorDTO doctorDTO = new DoctorDTO();
    DoctorDTO doctorDTO1 = new DoctorDTO();


    @Test
    public void getAllAndAddTestAndDelete() throws Exception {
        assert doctorDAOHashMap.getAll().size()==0;
        doctorDTO.setId(1L);
        doctorDAOHashMap.add(doctorDTO);
        doctorDTO1.setId(2L);
        doctorDAOHashMap.add(doctorDTO1);
        List doctors = doctorDAOHashMap.getAll();
        assert doctors.size()==2;
        assert doctors.contains(doctorDTO);
        assert doctors.contains(doctorDTO1);
        doctorDAOHashMap.deleteDoctorById(1L);
        doctors = doctorDAOHashMap.getAll();
        assert doctors.size()==1;
        assert doctors.contains(doctorDTO1);
        assert doctors.contains(doctorDTO)==false;

    }

    @Test
    public void getById() throws Exception {

        doctorDTO.setId(1L);
        doctorDTO.setName("Simon");
        doctorDTO.setSurname("Audi");
        doctorDTO.setTitle("doc");
        doctorDAOHashMap.add(doctorDTO);
        assert doctorDAOHashMap.getById(1).equals(doctorDTO);
        assert doctorDAOHashMap.getById(2)==null;


    }

}