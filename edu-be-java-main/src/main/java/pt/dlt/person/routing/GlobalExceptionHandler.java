package pt.dlt.person.routing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pt.dlt.person.exception.DoctorCreationException;
import pt.dlt.person.exception.NoDoctorFoundException;
import pt.dlt.person.exception.NoPatientFoundException;
import pt.dlt.person.exception.PatientCreationException;

import java.util.logging.Logger;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = Logger.getLogger(this.getClass().getName());


    @ExceptionHandler(NoDoctorFoundException.class)
    public ResponseEntity<String> handleNoDoctorFound(NoDoctorFoundException ex) {
        logger.warning(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(NoPatientFoundException.class)
    public ResponseEntity<String> handleNoPatientFound(NoPatientFoundException ex) {
        logger.warning(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(DoctorCreationException.class)
    public ResponseEntity<String> handleDoctorCreationFailure(DoctorCreationException ex) {
        logger.warning(ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(PatientCreationException.class)
    public ResponseEntity<String> handlePatientCreationFailure(PatientCreationException ex) {
        logger.warning(ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

}
