package dtt.formacao.java.consultas.model;

import dtt.formacao.java.consultas.utils.DocumentType;
import dtt.formacao.java.consultas.utils.Gender;

import java.util.Date;

public abstract class Person {

    private Long id;
    private String name;
    private String email;
    private Date brithDate;
    private String address;
    private String phoneNumber;
    private Integer fiscalNumber;
    private Gender gender;
    private DocumentType documentType;

    public Person(){

    }

    public Person(Long id, String name, String email, Date brithDate, String address, String phoneNumber, Integer fiscalNumber, Gender gender, DocumentType documentType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.brithDate = brithDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.fiscalNumber = fiscalNumber;
        this.gender = gender;
        this.documentType = documentType;
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

    public Date getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(Date brithDate) {
        this.brithDate = brithDate;
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

    public DocumentType getDocumentType(){
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }
}