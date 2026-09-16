package dtt.formacao.java.consultas.repository;

import dtt.formacao.java.consultas.model.Doctor;
import dtt.formacao.java.consultas.model.refs.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("""
       SELECT d
       FROM Doctor d
       JOIN d.specialties s
       WHERE s = :specialty
       """)
    List<Doctor> findBySpecialtiesContains(
            @Param("specialty") Specialty specialty
    );
}