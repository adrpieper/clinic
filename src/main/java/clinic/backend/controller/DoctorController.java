package clinic.backend.controller;


import clinic.backend.dao.DoctorDAO;
import clinic.backend.dto.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
