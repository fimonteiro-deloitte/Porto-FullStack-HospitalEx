package dtt.formacao.java.consultas.model;

import dtt.formacao.java.consultas.model.refs.DocumentType;
import dtt.formacao.java.consultas.model.refs.Gender;

public record PatientDTO(
        Long id,
        String name,
        String email,
        java.time.LocalDate birthDate,
        String address,
        String phoneNumber,
        Integer fiscalNumber,
        Gender gender,
        DocumentType documentType,
        Integer socialSecurityNumber,
        Integer insuranceNumber)
{ }
