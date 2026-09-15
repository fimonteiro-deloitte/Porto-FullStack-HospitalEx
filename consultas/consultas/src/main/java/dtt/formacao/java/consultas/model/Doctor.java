package dtt.formacao.java.consultas.model;

import dtt.formacao.java.consultas.model.refs.DocumentType;
import dtt.formacao.java.consultas.model.refs.Gender;
import dtt.formacao.java.consultas.model.refs.Specialty;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Doctor extends Person {

    private Specialty specialty;

    public Doctor() {
        super();
    }

    public Doctor(Long id,
                  String name,
                  String email,
                  Date brithDate,
                  String address,
                  String phoneNumber,
                  Integer fiscalNumber,
                  Gender gender,
                  DocumentType documentType,
                  Specialty specialty) {

        super(id, name, email, brithDate, address, phoneNumber,
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
