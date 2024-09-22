/**
 * pl.expiredateapp.services.exceptions is a package for database exceptions.
 */
package pl.expiredateapp.services.exceptions;

/**
 * Entity add exception.
 */
public class EntityAddException extends RuntimeException {

    /**
     * Entity add exception constructor.
     * @param s Message.
     */
    public EntityAddException(String s) { super(s);}
}
