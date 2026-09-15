package dtt.formacao.java.consultas.model;

import dtt.formacao.java.consultas.utils.DocumentType;
import dtt.formacao.java.consultas.utils.Gender;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Patient extends Person {

    private Integer socialSecurityNumber;
    private Integer insuranceNumber;

    public Patient() {
        super();
    }

    public Patient(Long id,
                   String name,
                   String email,
                   Date birthDate,
                   String address,
                   String phoneNumber,
                   Integer fiscalNumber,
                   Gender gender,
                   DocumentType documentType,
                   Integer socialSecurityNumber,
                   Integer insuranceNumber) {

        super(id, name, email, birthDate, address, phoneNumber,
                fiscalNumber, gender, documentType);

        this.socialSecurityNumber = socialSecurityNumber;
        this.insuranceNumber = insuranceNumber;
    }

    public Integer getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(Integer socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public Integer getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(Integer insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
}