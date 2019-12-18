package hu.flowacademy.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public List<String> handleRuntimeException(RuntimeException e) {
        System.err.println("got a validation error: " + e);
        return List.of(e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public List<String> youShallNotPass(Throwable e) {
        System.err.println("The other stuff");
        return List.of(e.getMessage());
    }

    @ExceptionHandler(IdValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<String> idValidationException(IdValidationException e) {
        System.err.println("Problem with ID");
        return List.of(e.getMessage());
    }

    @ExceptionHandler(TooLongException.class)
    @ResponseStatus(HttpStatus.LENGTH_REQUIRED)
    public List<String> tooLongException(TooLongException e) {
        System.err.println("Too long exception");
        return List.of(e.getMessage());
    }

    @ExceptionHandler(MissingParameterException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public List<String> missingParameterException(MissingParameterException e) {
        System.err.println("Missing parameter");
        return List.of(e.getMessage());
    }

    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public List<String> internalServerException(InternalServerException e) {
        System.err.println("Missing parameter");
        return List.of(e.getMessage());
    }

}
