package pt.dlt.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pt.dlt.person.model.dao.Doctor;
import pt.dlt.person.model.ref.Speciality;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByName(String name);

    @Query("SELECT d FROM Doctor d WHERE :speciality MEMBER OF d.specialities")
    List<Doctor> findDoctorBySpeciality(@Param("speciality") Speciality speciality);
}
