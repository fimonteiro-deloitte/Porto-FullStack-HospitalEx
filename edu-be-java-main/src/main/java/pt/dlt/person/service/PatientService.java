package pt.dlt.person.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import pt.dlt.person.exception.PatientCreationException;
import pt.dlt.person.model.dao.Patient;
import pt.dlt.person.exception.NoPatientFoundException;
import pt.dlt.person.model.dto.PatientRequest;
import pt.dlt.person.model.dto.PatientResponse;
import pt.dlt.person.repository.PatientRepository;
import pt.dlt.person.utils.MappingUtils;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    private final MappingUtils mapper;

    public PatientService(PatientRepository patientRepository, MappingUtils mapper) {
        this.patientRepository = patientRepository;
        this.mapper = mapper;
    }

    public PatientResponse createPatient(PatientRequest patientRequestDTO) throws PatientCreationException {
        var patient = mapper.mapPatient(patientRequestDTO);
        try {
            return mapper.mapPatient(patientRepository.save(patient));
        } catch (DataIntegrityViolationException e) {
            throw new PatientCreationException();
        }
    }

    public List<PatientResponse> getListPatients() {
        return mapper.mapPatients(patientRepository.findAll());
    }

    public PatientResponse getPatientById(Long id) throws NoPatientFoundException {
        Optional<Patient> response = patientRepository.findById(id);
        if (response.isEmpty()) {
            throw new NoPatientFoundException();
        }
        return mapper.mapPatient(response.get());
    }

    public PatientResponse updatePatient(long id, PatientRequest patientRequestDTO) throws NoPatientFoundException {
        Optional<Patient> response = patientRepository.findById(id);
        if (response.isEmpty()) {
            throw new NoPatientFoundException();
        }
        Patient patient = response.get();
        patient.setName(patientRequestDTO.name());
        patient.setPhoneNumber(patientRequestDTO.phoneNumber());
        patient.setGender(patientRequestDTO.gender());
        patient.setAddress(patientRequestDTO.address());
        patient.setDocumentType(patientRequestDTO.documentType());
        patient.setDocumentNumber(patientRequestDTO.documentNumber());
        patient.setFiscalNumber(patientRequestDTO.fiscalNumber());
        patient.setSocialSecurityNumber(patientRequestDTO.socialSecurityNumber());
        patientRepository.save(patient);
        return mapper.mapPatient(patient);
    }

    public void deletePatient(Long id) throws NoPatientFoundException {
        Optional<Patient> response = patientRepository.findById(id);
        if (response.isEmpty()) {
            throw new NoPatientFoundException();
        }
        patientRepository.delete(response.get());
    }
}
