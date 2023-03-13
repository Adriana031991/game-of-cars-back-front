package co.com.adrianafranklin.RetoCrudBackend.exception;

public class ValidationException extends RuntimeException {

    public ValidationException(String errorMessage) {
        super(errorMessage);
    }
}