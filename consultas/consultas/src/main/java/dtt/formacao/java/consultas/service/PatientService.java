package dtt.formacao.java.consultas.service;

import dtt.formacao.java.consultas.model.dao.Patient;
import dtt.formacao.java.consultas.model.dto.PatientDTO;
import dtt.formacao.java.consultas.repository.PatientRepository;
import dtt.formacao.java.consultas.utils.PatientMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientDTO> getAllPatients() {
        return patientRepository
            .findAll()
            .stream()
            .map(PatientMapper::toDTO)
            .toList();
    }

    public PatientDTO getPatient(long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        return PatientMapper.toDTO(patient.get());
    }

    public PatientDTO createPatient(PatientDTO newPatient) {
        Patient p = PatientMapper.toEntity(newPatient);
        Patient saved = patientRepository.save(p);
        return PatientMapper.toDTO(saved);
    }

    public PatientDTO updatePatient(long id, PatientDTO updatedDTO) {
        Patient updatedPatient = PatientMapper.toEntity(updatedDTO);

        Optional<Patient> tempPatient = patientRepository.findById(id);
        Patient patient = tempPatient.get();

        patient.setName(updatedPatient.getName());
        patient.setEmail(updatedPatient.getEmail());
        patient.setPhoneNumber(updatedPatient.getPhoneNumber());

        Patient saved = patientRepository.save(patient);
        return PatientMapper.toDTO(saved);
    }

    public void deletePatient(long id) {
        patientRepository.deleteById(id);
    }
}
