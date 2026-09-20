package pt.dlt.person.model;

import pt.dlt.person.model.ref.Speciality;

import java.util.List;

public interface DoctorProjection {
    long getId();
    String getName();
    List<Speciality> getSpecialities();
}
