package pt.dlt.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.dlt.person.model.dao.Doctor;
import pt.dlt.person.model.dao.Patient;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Doctor> findByName(String name);

}
