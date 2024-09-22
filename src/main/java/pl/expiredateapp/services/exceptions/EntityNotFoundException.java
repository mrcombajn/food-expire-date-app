/**
 * pl.expiredateapp.services.exceptions is a package for database exceptions.
 */
package pl.expiredateapp.services.exceptions;

/**
 * Entity not found exception.
 */
public class EntityNotFoundException extends RuntimeException {

    /**
     * Entity not found exception constructor.
     * @param s Message.
     */
    public EntityNotFoundException(String s) {
        super(s);
    }

}
