package com.ecommerceProject.Ecommerce.project.Exception;

import com.ecommerceProject.Ecommerce.project.DTO.ExceptionHandlerDTO;
import com.ecommerceProject.Ecommerce.project.controller.CategoryController;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CategoryController.class)
public class CategoryControllerExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionHandlerDTO> handleCategoryNotFoundException(CategoryNotFoundException ce){
        ExceptionHandlerDTO exceptionHandlerDTO = new ExceptionHandlerDTO(ce.getMessage(),404);
        return new ResponseEntity<>(exceptionHandlerDTO,HttpStatus.NOT_FOUND);
    }
}
