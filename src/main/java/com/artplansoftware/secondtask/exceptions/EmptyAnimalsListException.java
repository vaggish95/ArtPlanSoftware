package com.artplansoftware.secondtask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "В списке нет ни одного питомца.")
public class EmptyAnimalsListException extends RuntimeException {
}
