package pt.dlt.person.model.dto;

import pt.dlt.person.model.ref.DocumentType;
import pt.dlt.person.model.ref.Gender;
import pt.dlt.person.model.ref.Speciality;

import java.time.LocalDate;
import java.util.List;

public record DoctorRequest(
        String name,
        Gender gender,
        LocalDate birthdate,
        DocumentType documentType,
        String documentNumber,
        int fiscalNumber,
        Integer phoneNumber,
        String address,
        List<Speciality> specialities
) {}
