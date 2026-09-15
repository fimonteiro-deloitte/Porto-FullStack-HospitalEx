package dtt.formacao.java.consultas.routing;

import dtt.formacao.java.consultas.model.Patient;
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
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable long id) {
        return patientService.getPatient(id);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient newPatient) {
        return patientService.createPatient(newPatient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable long id, @RequestBody Patient updatedPatient) {
        return patientService.updatePatient(id, updatedPatient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable long id) {
        patientService.deletePatient(id);
    }
}
