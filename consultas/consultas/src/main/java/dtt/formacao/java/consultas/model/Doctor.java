package dtt.formacao.java.consultas.model;

import dtt.formacao.java.consultas.utils.DocumentType;
import dtt.formacao.java.consultas.utils.Gender;
import dtt.formacao.java.consultas.utils.Specialty;

import java.util.Date;

public class Doctor extends Person {

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
