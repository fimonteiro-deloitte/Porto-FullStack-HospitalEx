package pt.dlt.person.model.dto;

import pt.dlt.person.model.ref.DocumentType;
import pt.dlt.person.model.ref.Gender;

public record PatientResponse(
        long id,
        String name,
        Gender gender,
        int age,
        DocumentType documentType,
        String documentNumber,
        int fiscalNumber,
        Integer phoneNumber,
        String address,
        long socialSecurityNumber,
        String insuranceNumber
) {}
