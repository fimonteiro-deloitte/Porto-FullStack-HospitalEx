package dtt.formacao.java.consultas.model;


import dtt.formacao.java.consultas.model.refs.DocumentType;
import dtt.formacao.java.consultas.model.refs.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.util.Date;

@Entity
@Table(
        name = "patient",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"document_type", "fiscal_number"}
                )
        }
)
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