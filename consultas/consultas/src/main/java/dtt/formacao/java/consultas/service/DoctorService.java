package dtt.formacao.java.consultas.service;

import dtt.formacao.java.consultas.exception.DoctorNotFoundException;
import dtt.formacao.java.consultas.exception.InvalidDoctorDataException;
import dtt.formacao.java.consultas.model.dao.Doctor;
import dtt.formacao.java.consultas.model.dto.DoctorDTO;
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


    public DoctorDTO createDoctor(DoctorDTO dto) {
        Doctor doctor = DoctorMapper.toEntity(dto);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return DoctorMapper.toDTO(savedDoctor);
    }

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
        if (!doctorRepository.existsById(id)) {
            throw DoctorNotFoundException.forId(id);
        }
        doctorRepository.deleteById(id);
    }
    
}