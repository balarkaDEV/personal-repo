package com.fotos.photographer.master.service.advice;

import com.fotos.photographer.master.service.exception.PhotoGMasterBusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PhotoGMasterAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoGMasterAdvice.class);

    @ExceptionHandler(PhotoGMasterBusinessException.class)
    public ResponseEntity<String> handleBusinessException(PhotoGMasterBusinessException exception){
        return new ResponseEntity<String>(exception.getErrorMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception exception){
        LOGGER.error("Exception occurred:" + exception.getMessage());
        exception.printStackTrace();
        return new ResponseEntity<String>("A generic exception occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
