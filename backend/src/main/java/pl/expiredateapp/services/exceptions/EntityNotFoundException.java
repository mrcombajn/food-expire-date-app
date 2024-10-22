package pl.expiredateapp.services.exceptions;

public final class EntityNotFoundException extends RuntimeException {

    /**
     * Entity not found exception constructor.
     * @param s Message.
     */
    public EntityNotFoundException(final String s) {
        super(s);
    }

}
