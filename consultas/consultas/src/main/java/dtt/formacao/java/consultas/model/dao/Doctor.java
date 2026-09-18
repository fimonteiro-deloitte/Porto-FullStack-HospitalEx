package dtt.formacao.java.consultas.model.dao;

import dtt.formacao.java.consultas.model.refs.DocumentType;
import dtt.formacao.java.consultas.model.refs.Gender;
import dtt.formacao.java.consultas.model.refs.Specialty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(
        name = "doctor",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"document_type", "fiscal_number"}
                )
        }
)
public class Doctor extends Person {

    @ElementCollection
    @CollectionTable(
            name = "doctor_specialties",
            joinColumns = @JoinColumn(name = "doctor_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "specialty")
    private Set<Specialty> specialties = new HashSet<>();

    public Doctor() {
        super();
    }

    public Doctor(
            Long id,
            String name,
            String email,
            LocalDate birthDate,
            String address,
            String phoneNumber,
            Integer fiscalNumber,
            Gender gender,
            DocumentType documentType,
            Set<Specialty> specialties) {

        super(
                id,
                name,
                email,
                birthDate,
                address,
                phoneNumber,
                fiscalNumber,
                gender,
                documentType
        );

        this.specialties = specialties;
    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
