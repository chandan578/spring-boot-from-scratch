package com.example.CurdApplication.exception;

import com.example.CurdApplication.dto.ExceptionResDto;
import com.example.CurdApplication.dto.ValidationExceptionResDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResDto> handleRuntimeException(RuntimeException ex, HttpServletRequest request){
        ExceptionResDto exceptionRes = new ExceptionResDto(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionRes);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResDto> handleGenricException(Exception ex, HttpServletRequest request){
        ExceptionResDto exceptionRes = new ExceptionResDto(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionRes);
    }

    @ExceptionHandler(RescourceNotFoundException.class)
    public ResponseEntity<ExceptionResDto> handleResourceNotFoundException(RescourceNotFoundException ex, HttpServletRequest request){
        ExceptionResDto exceptionRes = new ExceptionResDto(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionRes);
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ExceptionResDto> handleDuplicateResourceException(DuplicateResourceException ex, HttpServletRequest request){
        ExceptionResDto exceptionRes = new ExceptionResDto(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionRes);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionResDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request){

        Map<String, String> fieldErrors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(
                error -> fieldErrors.put(error.getField(), error.getDefaultMessage())
        );

        ValidationExceptionResDto exceptionRes = new ValidationExceptionResDto(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                "Validation failed..",
                request.getRequestURI(),
                fieldErrors
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionRes);
    }
}
