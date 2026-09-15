package dtt.formacao.java.consultas.service;

import dtt.formacao.java.consultas.model.Patient;
import dtt.formacao.java.consultas.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatient(long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return patient.get();
    }

    public Patient createPatient(Patient newPatient) {
        return (Patient) patientRepository.save(newPatient);
    }

    public Patient updatePatient(long id, Patient p2) {

        Optional<Patient> tempPatient = patientRepository.findById(id);
        Patient patient = tempPatient.get();

        patient.setName(p2.getName());
        patient.setEmail(p2.getEmail());
        patient.setPhoneNumber(p2.getPhoneNumber());

        return (Patient) patientRepository.save(patient);
    }

    public void deletePatient(long id) {
        patientRepository.deleteById(id);
    }
}
