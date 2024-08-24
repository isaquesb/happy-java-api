package com.github.isaquesb.happy_java_api.app.http.handlers;

import com.github.isaquesb.happy_java_api.domain.common.exceptions.NotFoundException;
import com.github.isaquesb.happy_java_api.domain.common.exceptions.ValidationException;
import jakarta.annotation.Resource;
import org.springframework.context.MessageSource;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @Resource
    private MessageSource messageSource;

    private HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = error instanceof FieldError ? ((FieldError) error).getField() : error.getObjectName();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        var wrapper = new HashMap<String, Map<String, String>>();
        wrapper.put("errors", errors);

        return new ResponseEntity<>(wrapper, headers, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> handleRequestWithStatus(Exception e, WebRequest request, HttpStatus status) {
        String message = e.getMessage();
        ResponseError error = new ResponseError(message);
        return new ResponseEntity<>(error, headers(), status);
    }

    @ExceptionHandler(Throwable.class)
    private ResponseEntity<Object> handleGeneral(Exception e, WebRequest request) {
        return handleRequestWithStatus(e, request, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ValidationException.class)
    private ResponseEntity<Object> handleValidation(ValidationException e, WebRequest request) {
        return handleRequestWithStatus(e, request, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<Object> handleNotFound(NotFoundException e, WebRequest request) {
        return handleRequestWithStatus(e, request, HttpStatus.NOT_FOUND);
    }
}
