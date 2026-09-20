package pt.dlt.person.exception;

public class NoPatientFoundException extends Exception {
    
    public NoPatientFoundException() {
        super("No patient found with specified parameters!");
    }
    
}
