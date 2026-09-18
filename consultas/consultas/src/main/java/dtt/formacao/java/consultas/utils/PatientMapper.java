package dtt.formacao.java.consultas.utils;

import dtt.formacao.java.consultas.model.dao.Patient;
import dtt.formacao.java.consultas.model.dto.PatientDTO;

public class PatientMapper {

    private PatientMapper() {
    }

    public static PatientDTO toDTO(Patient patient) {
        if (patient == null) {
            return null;
        }

        return new PatientDTO(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getBirthDate(),
                patient.getAddress(),
                patient.getPhoneNumber(),
                patient.getFiscalNumber(),
                patient.getGender(),
                patient.getDocumentType(),
                patient.getSocialSecurityNumber(),
                patient.getInsuranceNumber()
        );
    }

    public static Patient toEntity(PatientDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Patient(
                dto.id(),
                dto.name(),
                dto.email(),
                dto.birthDate(),
                dto.address(),
                dto.phoneNumber(),
                dto.fiscalNumber(),
                dto.gender(),
                dto.documentType(),
                dto.socialSecurityNumber(),
                dto.insuranceNumber()
        );
    }
}
