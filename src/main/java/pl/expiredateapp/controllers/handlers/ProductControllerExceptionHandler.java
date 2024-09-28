package pl.expiredateapp.controllers.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import pl.expiredateapp.services.exceptions.EntityNotFoundException;

import java.util.Map;

@ControllerAdvice
public final class ProductControllerExceptionHandler
        extends ResponseEntityExceptionHandler {

    /**
     * Exception handler for EntityNotFoundException.
     * @param e Exception.
     * @return Response entity with
     * HttpStatus.BAD_REQUEST if exception occurs.
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleMissingDatabaseProduct(
            final EntityNotFoundException e) {
        return new ResponseEntity<>(
                Map.of("error", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
