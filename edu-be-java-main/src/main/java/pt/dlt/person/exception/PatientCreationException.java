package pt.dlt.person.exception;

public class PatientCreationException extends Exception {

    public PatientCreationException() {
        super("Failed to add patient. Please check the provided data.");
    }
    
}
