package com.artplansoftware.secondtask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Питомца с указанным именем не существует.")
public class AnimalNotFoundException extends RuntimeException {


}
