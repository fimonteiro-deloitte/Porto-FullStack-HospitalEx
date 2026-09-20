package pt.dlt.person.model.ref;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Speciality {
    ALLERGY_AND_IMMUNOLOGY("Allergy and Immunology"),
    ANESTHESIOLOGY("Anesthesiology"),
    DERMATOLOGY("Dermatology"),
    DIAGNOSTIC_RADIOLOGY("Diagnostic Radiology"),
    EMERGENCY_MEDICINE("Emergency Medicine"),
    FAMILY_MEDICINE("Family Medicine"),
    INTERNAL_MEDICINE("Internal Medicine"),
    MEDICAL("Medical"),
    NEUROLOGY("Neurology"),
    NUCLEAR_MEDICINE("Nuclear Medicine"),
    OBSTETRICS_AND_GYNECOLOGY("Obstetrics and Gynecology"),
    OPHTHALMOLOGY("Ophthalmology"),
    PATHOLOGY("Pathology"),
    PEDIATRICS("Pediatrics"),
    PHYSICAL_MEDICINE_AND_REHABILITATION("Physical Medicine and Rehabilitation"),
    PREVENTIVE_MEDICINE("Preventive Medicine"),
    PSYCHIATRY("Psychiatry"),
    RADIATION_ONCOLOGY("Radiation Oncology"),
    SURGERY("Surgery"),
    UROLOGY("Urology");

    private final String description;

    Speciality(String description) {
        this.description = description;
    }

    @JsonProperty("label")
    public String getDescription() {
        return description;
    }

    @JsonProperty("value")
    public String getValue() {
        return name();
    }
}
