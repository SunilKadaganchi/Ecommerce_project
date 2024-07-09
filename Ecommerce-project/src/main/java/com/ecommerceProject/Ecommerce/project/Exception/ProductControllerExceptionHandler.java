package com.ecommerceProject.Ecommerce.project.Exception;

import com.ecommerceProject.Ecommerce.project.DTO.ExceptionHandlerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionHandlerDTO> handleProductNotFoundExpection(ProductNotFoundException pe){
        ExceptionHandlerDTO exceptionHandlerDTO = new ExceptionHandlerDTO(
                pe.getMessage(),
                404
        );

        return new ResponseEntity<>(exceptionHandlerDTO, HttpStatus.NOT_FOUND);
    }


}
