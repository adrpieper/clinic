package clinic.backend.dao;

import clinic.backend.dto.DoctorDTO;
import org.junit.Test;

import java.util.HashMap;
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
    public void getAll() throws Exception {

    }

    @Test
    public void add() throws Exception {
        int a = doctorDAOHashMap.getAll().size();
        doctorDAOHashMap.add(doctorDTO);
        assert doctorDAOHashMap.getAll().size()==a+1;

    }

    @Test
    public void getById() throws Exception {

        doctorDTO.setId(1L);
        doctorDTO.setName("S");
        doctorDTO.setSurname("A");
        doctorDTO.setTitle("doc");
        doctorDAOHashMap.add(doctorDTO);
        assert doctorDAOHashMap.getById(1).getName().equals("S");
        assert doctorDAOHashMap.getById(1).getSurname().equals("y")==false;

    }

}