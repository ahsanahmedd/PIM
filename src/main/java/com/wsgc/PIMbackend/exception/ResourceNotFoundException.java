
package com.wsgc.PIMbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A "ResourceNotFound" class represents an exception or error handling mechanism for situations where a requested resource cannot be located or accessed.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){super(message);}
}
