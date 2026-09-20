package pt.dlt.person.exception;

public class NoDoctorFoundException extends Exception {
    
    public NoDoctorFoundException() {
        super("No doctor found with specified parameters!");
    }
    
}
