package pt.dlt.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pt.dlt.person.model.dao.Doctor;
import pt.dlt.person.model.DoctorProjection;
import pt.dlt.person.model.ref.Speciality;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    List<Doctor> findByName(String name);

    @Query("SELECT d.id AS id, d.name AS name, d.specialities AS specialities FROM Doctor d WHERE :speciality MEMBER OF d.specialities")
    List<DoctorProjection> findDoctorBySpeciality(@Param("speciality") Speciality speciality);
}
