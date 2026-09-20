package pt.dlt.person.utils;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import pt.dlt.person.model.dao.Doctor;
import pt.dlt.person.model.dao.Patient;
import pt.dlt.person.model.dto.DoctorRequest;
import pt.dlt.person.model.dto.DoctorResponse;
import pt.dlt.person.model.dto.PatientRequest;
import pt.dlt.person.model.dto.PatientResponse;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MappingUtils {
    Doctor mapDoctor(DoctorRequest doctorRequestDTO);

    @Mapping(target = "age", expression = "java(mapBirthdateToAge(doctor.getBirthdate()))")
    DoctorResponse mapDoctor(Doctor doctor);

    List<DoctorResponse> mapDoctors(List<Doctor> doctors);

    Patient mapPatient(PatientRequest patientRequestDTO);

    @Mapping(target = "age", expression = "java(mapBirthdateToAge(patient.getBirthdate()))")
    PatientResponse mapPatient(Patient patient);

    List<PatientResponse> mapPatients(List<Patient> patients);

    default int mapBirthdateToAge(LocalDate birthdate) {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }
}
