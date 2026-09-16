package dtt.formacao.java.consultas.routing;

import dtt.formacao.java.consultas.model.Doctor;
import dtt.formacao.java.consultas.model.DoctorDTO;
import dtt.formacao.java.consultas.service.DoctorService;
import dtt.formacao.java.consultas.model.refs.Specialty;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    /*
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }
*/
    @PostMapping
    public DoctorDTO createDoctor(@RequestBody DoctorDTO dto) {
        return doctorService.createDoctor(dto);
    }

    @PutMapping("/{id}")
    public DoctorDTO updateDoctor(@PathVariable Long id,
                               @RequestBody DoctorDTO doctor) {
        return doctorService.updateDoctor(id, doctor);
    }

    @GetMapping
    public List<DoctorDTO> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorDTO getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @GetMapping("/specialty/{specialty}")
    public List<DoctorDTO> getDoctorsBySpecialty(
            @PathVariable Specialty specialty) {
        return doctorService.getDoctorsBySpecialty(specialty);
    }

    @GetMapping("/specialties")
    public Specialty[] getSpecialties() {
        return Specialty.values();
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
    }
}