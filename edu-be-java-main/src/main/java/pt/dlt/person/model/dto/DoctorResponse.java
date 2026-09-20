package pt.dlt.person.model.dto;


import pt.dlt.person.model.ref.DocumentType;
import pt.dlt.person.model.ref.Gender;
import pt.dlt.person.model.ref.Speciality;

import java.util.List;

public record DoctorResponse(
        long id,
        String name,
        Gender gender,
        int age,
        DocumentType documentType,
        String documentNumber,
        int fiscalNumber,
        Integer phoneNumber,
        String address,
        List<Speciality> specialities
) {}