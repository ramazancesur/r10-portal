package tr.com.r10.portal.components;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import tr.com.r10.portal.dto.PortalException;
import tr.com.r10.portal.exceptions.NotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        PortalException portalException = new PortalException("ILLEGAL_ARGUMENT", "This should be application specific");
        return handleExceptionInternal(ex, portalException,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(
            RuntimeException ex, WebRequest request) {
        PortalException portalException = new PortalException(NotFoundException.MESSAGE_CODE, ex.getMessage());
        return handleExceptionInternal(ex, portalException,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}