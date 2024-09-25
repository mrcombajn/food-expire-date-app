package pl.expiredateapp.services.exceptions;

public final class EntityAddException extends RuntimeException {

    /**
     * Entity add exception constructor.
     * @param s Message.
     */
    public EntityAddException(final String s) { super(s);}
}
