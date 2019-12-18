package hu.flowacademy.demo.exception;

public class TooLongException extends ValidationException {

    public TooLongException(String message) {
        super(message);
    }
}
