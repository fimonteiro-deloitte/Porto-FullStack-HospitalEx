package pt.dlt.person;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pt.dlt.person.model.dao.Doctor;
import pt.dlt.person.model.dao.Patient;
import pt.dlt.person.model.ref.DocumentType;
import pt.dlt.person.model.ref.Gender;
import pt.dlt.person.repository.DoctorRepository;
import pt.dlt.person.repository.PatientRepository;

import java.time.LocalDate;
import java.util.List;

import static pt.dlt.person.model.ref.Speciality.*;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Person Management API",
				description = "API for managing doctors, patients and metadata in the hospital system."
		)
)
public class PersonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DoctorRepository doctorRepository, PatientRepository patientRepository) {
		return args -> {
			// It will populate only if it is empty
			if (doctorRepository.count() == 0) {
				Doctor d1 = new Doctor("João Silva", Gender.MALE, LocalDate.parse("1980-04-14"), DocumentType.CITIZEN_CARD, String.valueOf(13615516), 252945644, 916338296, "Rua da Esquina", List.of(FAMILY_MEDICINE, NEUROLOGY));
				Doctor d2 = new Doctor("Joana Silva", Gender.FEMALE, LocalDate.parse("1975-06-04"), DocumentType.CITIZEN_CARD, String.valueOf(13615515), 252945642, 916338298, "Rua da Chuva", List.of(UROLOGY));
				Doctor d3 = new Doctor("Maria Silva", Gender.FEMALE, LocalDate.parse("1970-07-30"), DocumentType.CITIZEN_CARD, String.valueOf(13615514), 252945640, 916338294, "Rua da Arquinha", List.of(PSYCHIATRY));
				doctorRepository.save(d1);
				doctorRepository.save(d2);
				doctorRepository.save(d3);
			}

			if (patientRepository.count() == 0) {
				Patient p1 = new Patient("John Snow", Gender.MALE, LocalDate.parse("1980-05-14"), DocumentType.PASSPORT,"AA136155", 252945638, 916338292, "Rua da Agonia", 82537843203L, "SA4314819-B");
				Patient p2 = new Patient("Beatriz Silva", Gender.FEMALE, LocalDate.parse("1975-05-04"), DocumentType.CITIZEN_CARD, String.valueOf(13615512), 252945636, 916338290, "Rua dos Prazeres", 82537843202L, "SA4314832-A");
				Patient p3 = new Patient("José Silva", Gender.MALE, LocalDate.parse("1970-06-30"), DocumentType.CITIZEN_CARD, String.valueOf(13615511), 252945634, 916338288, "Rua da Desgraça", 82537843201L, "SA4314856-B");
				Patient p4 = new Patient("Rute Silva", Gender.FEMALE, LocalDate.parse("1980-03-14"), DocumentType.CITIZEN_CARD, String.valueOf(13615510), 252945632, 916338286, "Rua da Moeda", 82537843200L, "SA4314834-C");
				Patient p5 = new Patient("Manuel Silva", Gender.MALE, LocalDate.parse("1970-03-14"), DocumentType.CITIZEN_CARD, String.valueOf(13615513), 252945638, 916338292, "Rua da Casa", 82537843203L, "SA4314819-B");
				Patient p6 = new Patient("Filipa Silva", Gender.FEMALE, LocalDate.parse("1975-05-04"), DocumentType.CITIZEN_CARD, String.valueOf(13615517), 252945636, 916338290, "Rua dos Calos", 82537843202L, "SA4314832-A");
				Patient p7 = new Patient("Joaquim Silva", Gender.MALE, LocalDate.parse("1970-06-30"), DocumentType.CITIZEN_CARD, String.valueOf(13615519), 252945634, 916338288, "Rua da Alegria", 82537843201L, "SA4314856-B");
				Patient p8 = new Patient("Sara Silva", Gender.FEMALE, LocalDate.parse("1980-03-14"), DocumentType.CITIZEN_CARD, String.valueOf(13615515), 252945632, 916338286, "Rua da Maria", 82537843200L, "SA4314834-C");
				patientRepository.save(p1);
				patientRepository.save(p2);
				patientRepository.save(p3);
				patientRepository.save(p4);
				patientRepository.save(p5);
				patientRepository.save(p6);
				patientRepository.save(p7);
				patientRepository.save(p8);
			}
		};
	}

}
