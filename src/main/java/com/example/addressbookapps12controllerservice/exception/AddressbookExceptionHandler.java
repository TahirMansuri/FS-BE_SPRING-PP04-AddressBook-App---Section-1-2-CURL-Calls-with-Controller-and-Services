package com.example.addressbookapps12controllerservice.exception;

import com.example.addressbookapps12controllerservice.dao.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class AddressbookExceptionHandler {

    /***
     * User friendly exception for User Data Validation
     * @param exception
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<ObjectError> objectErrorList = exception.getBindingResult().getAllErrors();
        List<String> errorMessageList = objectErrorList.stream()
                                                        .map(objectError -> objectError.getDefaultMessage())
                                                        .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception While Processing REST CALL",errorMessageList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
    }

    /***
     * User defined Custom exception for User Friendly Message
     * @param exception
     * @return
     */
    @ExceptionHandler(AddressbookException.class)
    public ResponseEntity<ResponseDTO> handleAddressbookException(AddressbookException exception) {
        ResponseDTO responseDTO = new ResponseDTO("Custome Exception while Processing Rest Call",exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
    }
}
