package dtt.formacao.java.consultas.exception;

public class DoctorNotFoundException extends RuntimeException {

    public DoctorNotFoundException(String message) {
        super(message);
    }

    public static DoctorNotFoundException forId(Long id) {
        return new DoctorNotFoundException("Doctor not found with id: " + id);
    }
}
