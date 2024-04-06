package com.project.cognizant.eventmanagementsystem.UserDefineException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotExistInDatabase extends RuntimeException{
    public NotExistInDatabase(String msg){
        super(msg);
    }
}
