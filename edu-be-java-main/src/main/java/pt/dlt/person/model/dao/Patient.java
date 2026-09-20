package pt.dlt.person.model.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import pt.dlt.person.model.ref.DocumentType;
import pt.dlt.person.model.ref.Gender;

import java.time.LocalDate;

@Entity
@Table(name = "patient", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"documentNumber", "documentType"})
})
public class Patient extends Person {
    private long socialSecurityNumber;
    private String insuranceNumber;


    public Patient() {}

    public Patient(String name, Gender gender, LocalDate birthdate, DocumentType documentType, String documentNumber, int fiscalNumber, Integer phoneNumber, String address, long socialSecurityNumber,
                   String insuranceNumber) {
        super(name, gender, birthdate, documentType, documentNumber, fiscalNumber, phoneNumber, address);
        this.setSocialSecurityNumber(socialSecurityNumber);
        this.setInsuranceNumber(insuranceNumber);
    }

    public long getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(long socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

}
