package dtt.formacao.java.consultas.routing;

import dtt.formacao.java.consultas.model.dto.PatientDTO;
import dtt.formacao.java.consultas.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientDTO> getAllPatients() {
        try {
            return patientService.getAllPatients();
        } catch (RuntimeException ex) {
            logger.error("Error fetching all patients", ex);
            throw ex;
        }
    }

    @GetMapping("/{id}")
    public PatientDTO getPatient(@PathVariable long id) {
        try {
            return patientService.getPatient(id);
        } catch (RuntimeException ex) {
            logger.error("Error fetching patient with id {}", id, ex);
            throw ex;
        }
    }

    @PostMapping
    public PatientDTO createPatient(@RequestBody PatientDTO newPatient) {
        try {
            return patientService.createPatient(newPatient);
        } catch (RuntimeException ex) {
            logger.error("Error creating patient", ex);
            throw ex;
        }
    }

    @PutMapping("/{id}")
    public PatientDTO updatePatient(@PathVariable long id, @RequestBody PatientDTO updatedPatient) {
        try {
            return patientService.updatePatient(id, updatedPatient);
        } catch (RuntimeException ex) {
            logger.error("Error updating patient with id {}", id, ex);
            throw ex;
        }
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable long id) {
        try {
            patientService.deletePatient(id);
        } catch (RuntimeException ex) {
            logger.error("Error deleting patient with id {}", id, ex);
            throw ex;
        }
    }
}
