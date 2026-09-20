package pt.dlt.person.model.dao;

import jakarta.persistence.*;
import pt.dlt.person.model.ref.DocumentType;
import pt.dlt.person.model.ref.Gender;
import pt.dlt.person.model.ref.Speciality;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "doctor", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"documentNumber", "documentType"})
})
public class Doctor extends Person {

    @ElementCollection(targetClass = Speciality.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "doctor_specialities", joinColumns = @JoinColumn(name = "doctor_id"))
    @Column(name = "speciality", nullable = false)
    private List<Speciality> specialities;

    public Doctor() {}

    public Doctor(String name, Gender gender, LocalDate birthdate, DocumentType documentType, String documentNumber, int fiscalNumber, Integer phoneNumber, String address, List<Speciality> specialities) {
        super(name, gender, birthdate, documentType, documentNumber, fiscalNumber, phoneNumber, address);
        this.specialities = specialities;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }
}
