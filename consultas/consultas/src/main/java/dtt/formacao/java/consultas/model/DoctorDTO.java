package dtt.formacao.java.consultas.model;

import dtt.formacao.java.consultas.model.refs.DocumentType;
import dtt.formacao.java.consultas.model.refs.Gender;
import dtt.formacao.java.consultas.model.refs.Specialty;

import java.util.Date;

public class DoctorDTO {

    private Long id;
    private String name;
    private String email;
    private Date birthDate;
    private String address;
    private String phoneNumber;
    private Integer fiscalNumber;
    private Gender gender;
    private DocumentType documentType;
    private Specialty specialty;

    public DoctorDTO() {
    }

    public DoctorDTO(Long id,
                     String name,
                     String email,
                     Date birthDate,
                     String address,
                     String phoneNumber,
                     Integer fiscalNumber,
                     Gender gender,
                     DocumentType documentType,
                     Specialty specialty) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.fiscalNumber = fiscalNumber;
        this.gender = gender;
        this.documentType = documentType;
        this.specialty = specialty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getFiscalNumber() {
        return fiscalNumber;
    }

    public void setFiscalNumber(Integer fiscalNumber) {
        this.fiscalNumber = fiscalNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
}