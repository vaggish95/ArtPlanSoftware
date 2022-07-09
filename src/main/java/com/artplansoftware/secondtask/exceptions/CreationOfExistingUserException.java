package com.artplansoftware.secondtask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Пользователь с таким именем уже существует.")
public class CreationOfExistingUserException extends RuntimeException{
}
