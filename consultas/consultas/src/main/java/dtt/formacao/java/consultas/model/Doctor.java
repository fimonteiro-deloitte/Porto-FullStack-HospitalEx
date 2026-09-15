package dtt.formacao.java.consultas.model;

import dtt.formacao.java.consultas.model.refs.DocumentType;
import dtt.formacao.java.consultas.model.refs.Gender;
import dtt.formacao.java.consultas.model.refs.Specialty;
import jakarta.persistence.*;

import java.util.Date;

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

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

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
                  Specialty specialty) {

        super(id, name, email, birthDate, address, phoneNumber,
                fiscalNumber, gender, documentType);

        this.specialty = specialty;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
}
