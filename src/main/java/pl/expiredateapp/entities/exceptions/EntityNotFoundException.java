package pl.expiredateapp.entities.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String s) {
        super(s);
    }
}
