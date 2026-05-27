package com.eduhub.eduhub_backend.Exception;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExpection {

    @ExceptionHandler(SourceNotFound.class)
    public ResponseEntity<Errorresponse> handleNotFound(SourceNotFound snf, HttpServletRequest request){
        Errorresponse errorResponse= new Errorresponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Not Found", snf.getMessage(),request.getRequestURI());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
}
