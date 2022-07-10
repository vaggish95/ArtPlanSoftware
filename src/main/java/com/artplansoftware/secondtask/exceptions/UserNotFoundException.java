package com.artplansoftware.secondtask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.NOT_FOUND, reason = "Пользователя с таким именем не существует.")
public class UserNotFoundException extends RuntimeException {

}
