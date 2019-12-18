package hu.flowacademy.demo.exception;

public class InternalServerException extends ValidationException {
    public InternalServerException(String message) {
        super(message);
    }
}
