package clinic.backend.controller;


import clinic.backend.dao.DoctorDAO;
import clinic.backend.dto.DoctorCreateDTO;
import clinic.backend.dto.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    private final DoctorDAO doctorDAO;

    @Autowired
    public DoctorController(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.GET)
    public List<DoctorDTO> getAllDoctors() {
        return doctorDAO.getAll();
    }

    @RequestMapping(value = "/doctors/{id}", method = RequestMethod.GET)
    public DoctorDTO getOneDoctor(@PathVariable long id) {
        return doctorDAO.getById(id);
    }

    @RequestMapping(value = "/doctors/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable long id) {
        doctorDAO.deleteDoctorById(id);
    }

    @RequestMapping(value = "/doctors", method = RequestMethod.POST)
    public void createNewDoctor(@RequestBody DoctorCreateDTO body) {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setName(body.getName());
        doctorDTO.setSurname(body.getSurname());
        doctorDTO.setTitle(body.getTitle());
        doctorDAO.save(doctorDTO);
    }

    @RequestMapping(value = "/doctors/{id}", method = RequestMethod.PUT)
    public void createNewDoctor(@PathVariable long id, @RequestBody DoctorCreateDTO body) {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setId(id);
        doctorDTO.setName(body.getName());
        doctorDTO.setSurname(body.getSurname());
        doctorDTO.setTitle(body.getTitle());
        doctorDAO.save(doctorDTO);
    }
}
