package pt.dlt.person.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import pt.dlt.person.exception.DoctorCreationException;
import pt.dlt.person.model.dao.Doctor;
import pt.dlt.person.model.dto.DoctorRequest;
import pt.dlt.person.model.dto.DoctorResponse;
import pt.dlt.person.model.ref.Speciality;
import pt.dlt.person.exception.NoDoctorFoundException;
import pt.dlt.person.repository.DoctorRepository;
import pt.dlt.person.utils.MappingUtils;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    private final MappingUtils mapper;

    public DoctorService(DoctorRepository doctorRepository, MappingUtils mapper) {
        this.doctorRepository = doctorRepository;
        this.mapper = mapper;
    }

    public DoctorResponse createDoctor(DoctorRequest doctorRequestDTO) throws DoctorCreationException {
        var doctor = mapper.mapDoctor(doctorRequestDTO);

        try {
            return mapper.mapDoctor(doctorRepository.save(doctor));
        } catch (DataIntegrityViolationException e) {
            throw new DoctorCreationException();
        }

    }

    public List<DoctorResponse> getListDoctors() {
        return mapper.mapDoctors(doctorRepository.findAll());
    }

    public DoctorResponse getDoctorById(Long id) throws NoDoctorFoundException {
        Optional<Doctor> response = doctorRepository.findById(id);
        if (response.isEmpty()) {
            throw new NoDoctorFoundException();
        }
        return mapper.mapDoctor(response.get());
    }

    public List<DoctorResponse> getDoctorsBySpeciality(Speciality speciality) {
        return mapper.mapDoctors(doctorRepository.findDoctorBySpeciality(speciality));
    }

    public DoctorResponse updateDoctor(long id, DoctorRequest doctorRequestDTO) throws NoDoctorFoundException {
        Optional<Doctor> response = doctorRepository.findById(id);
        if (response.isEmpty()) {
            throw new NoDoctorFoundException();
        }
        Doctor doctor = response.get();
        doctor.setName(doctorRequestDTO.name());
        doctor.setPhoneNumber(doctorRequestDTO.phoneNumber());
        doctor.setGender(doctorRequestDTO.gender());
        doctor.setAddress(doctorRequestDTO.address());
        doctor.setSpecialities(doctorRequestDTO.specialities());
        doctorRepository.save(doctor);
        return mapper.mapDoctor(doctor);
    }

    public void deleteDoctor(Long id) throws NoDoctorFoundException {
        Optional<Doctor> response = doctorRepository.findById(id);
        if (response.isEmpty()) {
            throw new NoDoctorFoundException();
        }
        doctorRepository.delete(response.get());
    }
}
