package com.ecommere.project.exceptions;

import com.ecommere.project.payload.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//Chỉ xử dụng cho Restcontroller, để xử lí các ngoại lệ tập trung có thể xảy ra ở tầng controller
@RestControllerAdvice
public class MyGlobalExceptionHandler {

    //Xử lí ngoại lệ cụ thể
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> myMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> response = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(err->{
            String filedName = ((FieldError)err).getField();
            String message = err.getDefaultMessage();
            response.put(filedName,message);
        });
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> myResourceNotFoundException(ResourceNotFoundException e){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setMessage(e.getMessage());
        apiResponse.setStatus(false);

        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(APIException.class)
    public ResponseEntity<APIResponse> myAPIException(APIException e){
        APIResponse apiResponse = new APIResponse();
        apiResponse.setMessage(e.getMessage());
        apiResponse.setStatus(false);
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
