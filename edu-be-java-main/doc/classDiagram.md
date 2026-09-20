```mermaid

classDiagram
  class Person {
  <<abstract>>
 - id
  - name
  - gender
  - birthdate
  - documentType
  - documentNumber
  - fiscalNumber
  - phoneNumber
  - address
  }

      class Doctor {
          - specialities
      }

      class Patient {
          - socialSecurityNumber
          - insuranceNumber
      }

      class Appointment {
          - id
          - startDate
          - endDate
      }


    class Speciality {
        <<enum>>
        + Dermatology
        + Pediatrics
        + Neurology
        + ...
    }

    class Gender {
        <<enum>>
        + Male
        + Female
        + Other
    }

    class DocumentType {
        <<enum>>
        + CitizenCard
        + Passport
    }

    Doctor --|> Person
    Patient --|> Person

    Appointment "0..*" -- "1" Patient
    Appointment "0..*" -- "1" Doctor

    Doctor --> Speciality

    Person --> Gender
    Person --> DocumentType