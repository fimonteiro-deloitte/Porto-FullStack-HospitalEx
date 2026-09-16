package dtt.formacao.java.consultas.service;

import dtt.formacao.java.consultas.model.dao.Patient;
import dtt.formacao.java.consultas.model.dto.PatientDTO;
import dtt.formacao.java.consultas.model.refs.Gender;
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

    public PatientDTO getPatient(long id) throws Exception {
        Optional<Patient> patient = patientRepository.findById(id);

        try {
            if (!patient.isPresent())
                throw new NullPointerException("Patient with id " + id + " not found.");
            Patient p = patient.get();
            validatePatient(p);
        } catch (Exception e) {
            throw new Exception("Patient creation failed: " + e.getMessage(), e);
        }

        return PatientMapper.toDTO(patient.get());
    }

    public PatientDTO createPatient(PatientDTO newPatient) throws Exception {
        Patient p = PatientMapper.toEntity(newPatient);
        try {
            validatePatient(p);
        } catch (Exception e) {
            throw new Exception("Patient creation failed: " + e.getMessage(), e);
        }

        Patient saved = patientRepository.save(p);
        return PatientMapper.toDTO(saved);
    }

    public PatientDTO updatePatient(long id, PatientDTO updatedDTO) throws Exception {
        Patient updatedPatient = PatientMapper.toEntity(updatedDTO);
        Optional<Patient> tempPatient;

        try {
            validatePatient(updatedPatient);
            tempPatient = patientRepository.findById(id);
            if (!tempPatient.isPresent()) {
                throw new Exception("Patient with id " + id + " not found.");
            }
        } catch (Exception e) {
            throw new Exception("Patient update failed: " + e.getMessage(), e);
        }

        Patient patient = tempPatient.get();

        patient.setName(updatedPatient.getName());
        patient.setEmail(updatedPatient.getEmail());
        patient.setPhoneNumber(updatedPatient.getPhoneNumber());
        patient.setGender(updatedPatient.getGender());

        Patient saved = patientRepository.save(patient);
        return PatientMapper.toDTO(saved);
    }

    public void deletePatient(long id) {
        patientRepository.deleteById(id);
    }

    private void validatePatient(Patient p) {
        if (p == null)
            throw new NullPointerException("Patient object cannot be null.");
        if (!isPhoneNumberValid(p))
            throw new IllegalArgumentException("Invalid phone number. It must contain exactly 9 digits.");
        if (!isGenderValid(p))
            throw new IllegalArgumentException("Invalid gender. Allowed values are MALE or FEMALE.");
    }

    private boolean isPhoneNumberValid(Patient p) {
        String phoneNumber = p.getPhoneNumber();
        return phoneNumber != null
                && !phoneNumber.isBlank()
                && phoneNumber.length() == 9
                && phoneNumber.matches("\\d+");
    }

    private boolean isGenderValid(Patient p) {
        Gender gender = p.getGender();
        return (gender == Gender.MALE || gender == Gender.FEMALE);
    }
}
