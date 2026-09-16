package dtt.formacao.java.consultas.routing;

import dtt.formacao.java.consultas.model.DoctorDTO;
import dtt.formacao.java.consultas.service.DoctorService;
import dtt.formacao.java.consultas.model.refs.Specialty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public DoctorDTO createDoctor(@RequestBody DoctorDTO dto) {
        try {
            return doctorService.createDoctor(dto);
        } catch (RuntimeException ex) {
            logger.error("Error creating doctor", ex);
            throw ex;
        }
    }

    @PutMapping("/{id}")
    public DoctorDTO updateDoctor(@PathVariable Long id,
                               @RequestBody DoctorDTO doctor) {
        try {
            return doctorService.updateDoctor(id, doctor);
        } catch (RuntimeException ex) {
            logger.error("Error updating doctor with id {}", id, ex);
            throw ex;
        }
    }

    @GetMapping
    public List<DoctorDTO> getAllDoctors() {
        try {
            return doctorService.getAllDoctors();
        } catch (RuntimeException ex) {
            logger.error("Error fetching all doctors", ex);
            throw ex;
        }
    }

    @GetMapping("/{id}")
    public DoctorDTO getDoctorById(@PathVariable Long id) {
        try {
            return doctorService.getDoctorById(id);
        } catch (RuntimeException ex) {
            logger.error("Error fetching doctor with id {}", id, ex);
            throw ex;
        }
    }

    @GetMapping("/specialty/{specialty}")
    public List<DoctorDTO> getDoctorsBySpecialty(
            @PathVariable Specialty specialty) {
        try {
            return doctorService.getDoctorsBySpecialty(specialty);
        } catch (RuntimeException ex) {
            logger.error("Error fetching doctors with specialty {}", specialty, ex);
            throw ex;
        }
    }

    @GetMapping("/specialties")
    public Specialty[] getSpecialties() {
        try {
            return Specialty.values();
        } catch (RuntimeException ex) {
            logger.error("Error fetching specialties", ex);
            throw ex;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        try {
            doctorService.deleteDoctor(id);
        } catch (RuntimeException ex) {
            logger.error("Error deleting doctor with id {}", id, ex);
            throw ex;
        }
    }
}