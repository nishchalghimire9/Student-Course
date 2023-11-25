package com.studentAPI.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<ExceptionErrorDetails> handleException(String exceptionMessage) { // just parameter is passed i do not know he purpose.
//
//        ExceptionErrorDetails appEx = new ExceptionErrorDetails();
//        appEx.setExcCode("400");
//        appEx.setExcDescription(exceptionMessage);
//        appEx.setExecLocaldate(LocalDateTime.now());
//        return new ResponseEntity<ExceptionErrorDetails>(appEx, HttpStatus.INTERNAL_SERVER_ERROR);
//
//
//    }
    // this one for department exception handle
    @ExceptionHandler( value = DepartmentNotFoundException.class)
    public ResponseEntity<ExceptionErrorDetails> handle_Exception() {
        ExceptionErrorDetails exeDetails = new ExceptionErrorDetails();
        exeDetails.setCurrentTime(LocalDateTime.now());
        exeDetails.setExcDescription("Department id is not exist");
        exeDetails.setExcCode("404");

    return new ResponseEntity<>(exeDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler( value = PhonenumberExistExe.class)
    public ResponseEntity<ExceptionErrorDetails> duplicate_ph_exe() {
        ExceptionErrorDetails exeDetails = new ExceptionErrorDetails();
        exeDetails.setCurrentTime(LocalDateTime.now());
        exeDetails.setExcDescription("phone number is exist please try another one.");
        exeDetails.setExcCode("404");

        return new ResponseEntity<>(exeDetails, HttpStatus.CONFLICT);

    }

}