package dtt.formacao.java.consultas.model.dto;

import dtt.formacao.java.consultas.model.refs.DocumentType;
import dtt.formacao.java.consultas.model.refs.Gender;
import dtt.formacao.java.consultas.model.refs.Specialty;

import java.util.List;
import java.time.LocalDate;
import java.util.Set;


public record DoctorDTO(
        Long id,
        String name,
        String email,
        LocalDate birthDate,
        String address,
        String phoneNumber,
        Integer fiscalNumber,
        Gender gender,
        DocumentType documentType,
        Set<Specialty> specialties
) {
}