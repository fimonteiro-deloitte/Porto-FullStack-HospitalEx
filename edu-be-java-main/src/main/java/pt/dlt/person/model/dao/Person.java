package pt.dlt.person.model.dao;

import jakarta.persistence.*;
import pt.dlt.person.model.ref.DocumentType;
import pt.dlt.person.model.ref.Gender;

import java.time.LocalDate;

@MappedSuperclass
public abstract class Person extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private LocalDate birthdate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DocumentType documentType;
    @Column(nullable = false)
    private String documentNumber;
    private int fiscalNumber;
    private Integer phoneNumber;
    @Column(nullable = false)
    private String address;


    Person() {}

    Person(String name, Gender gender, LocalDate birthdate, DocumentType documentType, String documentNumber, int fiscalNumber, Integer phoneNumber, String address) {
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.fiscalNumber = fiscalNumber;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }


    public int getFiscalNumber() {
        return fiscalNumber;
    }

    public void setFiscalNumber(int fiscalNumber) {
        this.fiscalNumber = fiscalNumber;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
