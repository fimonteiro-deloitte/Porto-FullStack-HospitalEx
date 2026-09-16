package dtt.formacao.java.consultas.utils;

import dtt.formacao.java.consultas.model.DoctorDTO;
import dtt.formacao.java.consultas.model.Doctor;

public class DoctorMapper {

    private DoctorMapper() {
        // Prevent instantiation
    }

    public static DoctorDTO toDTO(Doctor doctor) {
        if (doctor == null) {
            return null;
        }

        return new DoctorDTO(
                doctor.getId(),
                doctor.getName(),
                doctor.getEmail(),
                doctor.getBirthDate(),
                doctor.getAddress(),
                doctor.getPhoneNumber(),
                doctor.getFiscalNumber(),
                doctor.getGender(),
                doctor.getDocumentType(),
                doctor.getSpecialty()
        );
    }

    public static Doctor toEntity(DoctorDTO dto) {
        if (dto == null) {
            return null;
        }

        return new Doctor(
                dto.getId(),
                dto.getName(),
                dto.getEmail(),
                dto.getBirthDate(),
                dto.getAddress(),
                dto.getPhoneNumber(),
                dto.getFiscalNumber(),
                dto.getGender(),
                dto.getDocumentType(),
                dto.getSpecialty()
        );
    }
}