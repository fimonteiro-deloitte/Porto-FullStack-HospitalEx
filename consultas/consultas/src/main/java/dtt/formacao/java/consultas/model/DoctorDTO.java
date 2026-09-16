package dtt.formacao.java.consultas.model;

import dtt.formacao.java.consultas.model.refs.DocumentType;
import dtt.formacao.java.consultas.model.refs.Gender;
import dtt.formacao.java.consultas.model.refs.Specialty;

import java.util.Date;

public record DoctorDTO(
        Long id,
        String name,
        String email,
        Date birthDate,
        String address,
        String phoneNumber,
        Integer fiscalNumber,
        Gender gender,
        DocumentType documentType,
        Specialty specialty
) {
}