package cz.itnetwork.controller.advice;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.webjars.NotFoundException;

/**
 * Global exception handler for handling specific exceptions related to entity not found scenarios.
 *
 * <p>This class uses Spring's {@link ControllerAdvice} to globally handle exceptions thrown by controllers
 * that are related to entities not being found. It provides a centralized mechanism to manage
 * HTTP responses for such exceptions.</p>
 *
 * <p>It handles the following exceptions:</p>
 * <ul>
 *     <li>{@link NotFoundException} - thrown when a resource is not found, typically from WebJars</li>
 *     <li>{@link EntityNotFoundException} - thrown when an entity is not found in the database</li>
 * </ul>
 *
 * <p>When either of these exceptions is thrown, the handler method responds with an HTTP status code 404 (Not Found).</p>
 *
 * @version 1.0
 * @since 2024
 */
@ControllerAdvice
public class EntityNotFoundExceptionAdvice {

    /**
     * Handles exceptions of type {@link NotFoundException} and {@link EntityNotFoundException}.
     *
     * <p>This method is invoked when a {@link NotFoundException} or {@link EntityNotFoundException} is thrown.
     * It sets the HTTP response status to 404 (Not Found), indicating that the requested resource could not be found.</p>
     */
    @ExceptionHandler({NotFoundException.class, EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleEntityNotFoundException() {
    }

}

