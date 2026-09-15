package dtt.formacao.java.consultas.model;

import dtt.formacao.java.consultas.utils.DocumentType;
import dtt.formacao.java.consultas.utils.Gender;

import java.util.Date;

public class Patient extends Person {

    private Integer socialSecurityNumeber;
    private Integer insuranceNumber;

    public Patient() {
        super();
    }

    public Patient(Long id,
                   String name,
                   String email,
                   Date brithDate,
                   String address,
                   String phoneNumber,
                   Integer fiscalNumber,
                   Gender gender,
                   DocumentType documentType,
                   Integer socialSecurityNumeber,
                   Integer insuranceNumber) {

        super(id, name, email, brithDate, address, phoneNumber,
                fiscalNumber, gender, documentType);

        this.socialSecurityNumeber = socialSecurityNumeber;
        this.insuranceNumber = insuranceNumber;
    }

    public Integer getSocialSecurityNumeber() {
        return socialSecurityNumeber;
    }

    public void setSocialSecurityNumeber(Integer socialSecurityNumeber) {
        this.socialSecurityNumeber = socialSecurityNumeber;
    }

    public Integer getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(Integer insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
}