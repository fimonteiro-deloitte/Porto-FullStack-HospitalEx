package dtt.formacao.java.consultas.routing;

import dtt.formacao.java.consultas.model.PatientDTO;
import dtt.formacao.java.consultas.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<PatientDTO> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientDTO getPatient(@PathVariable long id) {
        return patientService.getPatient(id);
    }

    @PostMapping
    public PatientDTO createPatient(@RequestBody PatientDTO newPatient) {
        return patientService.createPatient(newPatient);
    }

    @PutMapping("/{id}")
    public PatientDTO updatePatient(@PathVariable long id, @RequestBody PatientDTO updatedPatient) {
        return patientService.updatePatient(id, updatedPatient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable long id) {
        patientService.deletePatient(id);
    }
}
