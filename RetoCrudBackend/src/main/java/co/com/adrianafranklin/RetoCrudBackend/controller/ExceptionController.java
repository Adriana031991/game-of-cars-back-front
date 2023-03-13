package co.com.adrianafranklin.RetoCrudBackend.controller;

import co.com.adrianafranklin.RetoCrudBackend.DTO.ResponseDto;
import co.com.adrianafranklin.RetoCrudBackend.exception.ValidationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {ValidationException.class})
        public ResponseDto validationException(HttpServletResponse response, RuntimeException e){
        response.setStatus(400);
        return new ResponseDto(e.getMessage());
    }
}
