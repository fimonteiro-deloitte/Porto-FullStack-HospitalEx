package dtt.formacao.java.consultas.service;

import dtt.formacao.java.consultas.model.Doctor;
import dtt.formacao.java.consultas.utils.Specialty;

import java.util.List;

public interface DoctorService {

    Doctor createDoctor(Doctor doctor);

    Doctor updateDoctor(Long id, Doctor doctor);

    Doctor getDoctorById(Long id);

    List<Doctor> getAllDoctors();

    List<Doctor> getDoctorsBySpecialty(Specialty specialty);
}
