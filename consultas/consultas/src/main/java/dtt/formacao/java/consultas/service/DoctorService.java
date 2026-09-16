package dtt.formacao.java.consultas.service;

import dtt.formacao.java.consultas.model.Doctor;
import dtt.formacao.java.consultas.model.DoctorDTO;
import dtt.formacao.java.consultas.repository.DoctorRepository;
import dtt.formacao.java.consultas.model.refs.Specialty;
import dtt.formacao.java.consultas.utils.DoctorMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    /*
    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
    */

    public DoctorDTO createDoctor(DoctorDTO dto) {
        Doctor doctor = DoctorMapper.toEntity(dto);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return DoctorMapper.toDTO(savedDoctor);
    }

    /*
    public Doctor updateDoctor(Long id, Doctor doctor) {
        doctor.setId(id);
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Doctor not found"));
    }

    public List<Doctor> getDoctorsBySpecialty(Specialty specialty) {
        return doctorRepository.findBySpecialty(specialty);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
    */

    public DoctorDTO updateDoctor(Long id, DoctorDTO dto) {
        Doctor doctor = DoctorMapper.toEntity(dto);
        doctor.setId(id);

        Doctor updatedDoctor = doctorRepository.save(doctor);

        return DoctorMapper.toDTO(updatedDoctor);
    }

    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll()
                .stream()
                .map(DoctorMapper::toDTO)
                .toList();
    }

    public DoctorDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        return DoctorMapper.toDTO(doctor);
    }

    public List<DoctorDTO> getDoctorsBySpecialty(Specialty specialty) {
        return doctorRepository
                .findBySpecialtiesContains(specialty)
                .stream()
                .map(DoctorMapper::toDTO)
                .toList();
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
    
}