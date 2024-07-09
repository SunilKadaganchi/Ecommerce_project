package com.ecommerceProject.Ecommerce.project.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionHandlerDTO {
    private String message;
    private int code;

    public ExceptionHandlerDTO(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
