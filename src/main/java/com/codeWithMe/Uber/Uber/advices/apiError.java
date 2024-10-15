package com.codeWithMe.Uber.Uber.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
public class apiError {

    private HttpStatus status;
    private String message;
    private List<String> subErrors;
}
