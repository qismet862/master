package com.example.glmrbackend.handler;

import com.example.glmrbackend.dto.ErrorResponseDto;
import com.example.glmrbackend.logger.MainLogger;
import com.example.glmrbackend.model.exception.UniqueNumber;
import com.example.glmrbackend.model.exception.UserExists;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler {

    private static final MainLogger LOGGER = MainLogger.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {
        return buildResponseEntity(ex, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        return getResponseEntity(ex, status, request, "Validation failed");
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex,
            @Nullable Object body,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        return getResponseEntity(ex, status, request, "Internal exception message");
    }

    private ResponseEntity<Object> buildResponseEntity(Exception ex, WebRequest request) {
        String message;
        HttpStatus status;
        if (ex instanceof UserExists) {
            message = "User not found";
            status = HttpStatus.NOT_FOUND;
        }
        else if (ex instanceof UniqueNumber) {
            message = "Number must be unique";
            status = HttpStatus.BAD_REQUEST;
        }
        else {
            message = HttpStatus.INTERNAL_SERVER_ERROR.name();
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        LOGGER.error("{} : {}", ex.getClass(), ex.getMessage());
        return getResponseEntity(ex, status, request, message);
    }

    private ResponseEntity<Object> getResponseEntity(Exception ex,
                                                     HttpStatus status,
                                                     WebRequest request,
                                                     String message) {
        ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
                .errorCode(status.value())
//                .error(status.getReasonPhrase())
                .message(ex.getMessage())
//                .errorDetail(ex.getMessage())
//                .path(((ServletWebRequest) request).getRequest().getRequestURI())
//                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(errorResponseDto, status);
    }

}
