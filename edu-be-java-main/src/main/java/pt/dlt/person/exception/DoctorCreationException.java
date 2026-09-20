package pt.dlt.person.exception;

public class DoctorCreationException extends Exception {

    public DoctorCreationException() {
        super("Failed to add doctor. Please check the provided data.");
    }
    
}
