package hu.flowacademy.demo.exception;

public class MissingParameterException extends ValidationException {

    public MissingParameterException(String message) {
        super(message);
    }
}
