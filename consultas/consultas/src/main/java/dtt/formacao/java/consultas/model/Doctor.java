package dtt.formacao.java.consultas.model;

import dtt.formacao.java.consultas.model.refs.DocumentType;
import dtt.formacao.java.consultas.model.refs.Gender;
import dtt.formacao.java.consultas.model.refs.Specialty;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

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
    private List<Specialty> specialties;

    public Doctor() {
        super();
    }

    public Doctor(Long id,
                  String name,
                  String email,
                  Date birthDate,
                  String address,
                  String phoneNumber,
                  Integer fiscalNumber,
                  Gender gender,
                  DocumentType documentType,
                  List<Specialty> specialties) {

        super(id, name, email, birthDate, address, phoneNumber,
                fiscalNumber, gender, documentType);

        this.specialties = specialties;
    }

    public List<Specialty> getSpecialty() {
        return specialties;
    }

    public void setSpecialty(List<Specialty> specialty) {
        this.specialties = specialties;
    }
}
