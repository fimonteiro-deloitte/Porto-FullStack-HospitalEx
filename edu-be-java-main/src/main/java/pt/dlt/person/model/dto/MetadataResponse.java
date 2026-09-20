package pt.dlt.person.model.dto;

import pt.dlt.person.model.ref.DocumentType;
import pt.dlt.person.model.ref.Gender;
import pt.dlt.person.model.ref.Speciality;

import java.util.List;

public record MetadataResponse(
        List<Speciality> specialities,
        List<Gender> genders,
        List<DocumentType> documentTypes
) {}
