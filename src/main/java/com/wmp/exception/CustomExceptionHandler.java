package com.wmp.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String wrongNumberOfInput(Exception e) {
        log.info("# Exception {}", e.getMessage());
        return "서버에서 오류가 발생하였습니다.";
    }

    @ExceptionHandler(DomainNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String wrongNameOfDomain(Exception e) {
        log.info("# wrongNameOfDomain {}", e.getMessage());
        return e.getMessage();
    }
}
