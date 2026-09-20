package pt.dlt.person.model.dto;

import pt.dlt.person.model.ref.DocumentType;
import pt.dlt.person.model.ref.Gender;

import java.time.LocalDate;

public record PatientRequest(
        String name,
        Gender gender,
        LocalDate birthdate,
        DocumentType documentType,
        String documentNumber,
        int fiscalNumber,
        Integer phoneNumber,
        String address,
        long socialSecurityNumber,
        String insuranceNumber
) {}
